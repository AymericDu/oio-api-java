package io.openio.sds.http;

import static io.openio.sds.common.JsonUtils.gson;
import static io.openio.sds.common.OioConstants.OIO_CHARSET;
import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

import io.openio.sds.exceptions.AliasDeletedException;
import io.openio.sds.exceptions.BadRequestException;
import io.openio.sds.exceptions.ChunkNotFoundException;
import io.openio.sds.exceptions.ContainerExistException;
import io.openio.sds.exceptions.ContainerNotEmptyException;
import io.openio.sds.exceptions.ContainerNotFoundException;
import io.openio.sds.exceptions.ObjectExistException;
import io.openio.sds.exceptions.ObjectNotFoundException;
import io.openio.sds.exceptions.OioException;
import io.openio.sds.exceptions.OioSystemException;
import io.openio.sds.exceptions.ReferenceNotFoundException;
import io.openio.sds.models.ProxyError;

/**
 * 
 * @author Christopher Dedeurwaerder
 *
 */
public class Verifiers {

    public static final OioHttpResponseVerifier REFERENCE_VERIFIER = new OioHttpResponseVerifier() {

        @Override
        public void verify(OioHttpResponse resp) throws OioException {
            if (200 == resp.code() || 201 == resp.code()
                    || 204 == resp.code())
                return;
            ProxyError err = extractError(resp);
            switch (err.status()) {
            case 406:
                throw new ReferenceNotFoundException(err.toString());
            case 400:
                throw new BadRequestException(err.toString());
            case 404:
                throw new ReferenceNotFoundException(err.toString());
            case 500:
                throw new OioSystemException(err.toString());
            default:
                throw new OioSystemException(err.toString());
            }
        }
    };

    public static final OioHttpResponseVerifier CONTAINER_VERIFIER = new OioHttpResponseVerifier() {

        @Override
        public void verify(OioHttpResponse resp) throws OioException {
            if (200 == resp.code() || 201 == resp.code()
                    || 204 == resp.code())
                return;
            ProxyError err = extractError(resp);
            switch (err.status()) {
            case 400:
                throw new BadRequestException(err.toString());
            case 406:
            case 431:
                throw new ContainerNotFoundException(err.toString());
            case 433:
                throw new ContainerExistException(err.toString());
            case 438:
                throw new ContainerNotEmptyException(err.toString());
            case 500:
                throw new OioSystemException(err.toString());
            default:
                throw new OioSystemException(err.toString());
            }
        }
    };

    public static final OioHttpResponseVerifier OBJECT_VERIFIER = new OioHttpResponseVerifier() {

        @Override
        public void verify(OioHttpResponse resp) throws OioException {
            if (200 == resp.code() || 201 == resp.code()
                    || 204 == resp.code())
                return;
            ProxyError err = extractError(resp);
            switch (err.status()) {
            case 400:
                throw new BadRequestException(err.toString());
            case 406:
            case 431:
                throw new ContainerNotFoundException(err.toString());
            case 420:
                throw new ObjectNotFoundException(err.toString());
            case 421:
                throw new ObjectExistException(err.toString());
            case 426:
                throw new AliasDeletedException(err.toString());
            case 500:
                throw new OioSystemException(err.toString());
            default:
                throw new OioSystemException(err.toString());
            }
        }
    };

    public static final OioHttpResponseVerifier STANDALONE_VERIFIER = new OioHttpResponseVerifier() {

        @Override
        public void verify(OioHttpResponse resp) throws OioException {
            if (200 == resp.code() || 201 == resp.code()
                    || 204 == resp.code())
                return;
            ProxyError err = extractError(resp);
            switch (err.status()) {
            case 400:
                throw new BadRequestException(err.toString());
            case 404:
                throw new OioException(err.toString());
            case 500:
                throw new OioSystemException(err.toString());
            default:
                throw new OioSystemException(err.toString());
            }
        }
    };

    public static final OioHttpResponseVerifier RAWX_VERIFIER = new OioHttpResponseVerifier() {

        @Override
        public void verify(OioHttpResponse resp) throws OioException {
            switch (resp.code()) {
            case 200:
            case 201:
            case 204:
            case 206:
                return;
            case 400:
                char[] buf = new char[256];
                try {
                    new InputStreamReader(resp.body()).read(buf);
                    throw new BadRequestException(resp.msg() + new String(buf));
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new BadRequestException(resp.msg());
                }
            case 404:
                throw new ChunkNotFoundException(resp.msg());
            case 500:
                throw new OioException(format("Internal error (%d %s)",
                        resp.code(), resp.msg()));
            default:
                throw new OioException(format("Unmanaged response code (%d %s)",
                        resp.code(), resp.msg()));
            }
        }
    };

    private static ProxyError extractError(OioHttpResponse resp) {
        return gson().fromJson(
                new JsonReader(new InputStreamReader(resp.body(),
                        OIO_CHARSET)),
                ProxyError.class);
    }
}

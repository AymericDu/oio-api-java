package io.openio.sds.common;

import java.nio.charset.Charset;

public class OioConstants {

    public static final Charset OIO_CHARSET = Charset.forName("UTF-8");
    
    /* -- http methods names -- */
    
    public static final String PUT_METHOD = "PUT";
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    public static final String DELETE_METHOD = "DELETE";
    
    /* -- proxyd common headers -- */

    public static final String CONTENT_LENGTH_HEADER ="Content-Length";
    public static final String CONTENT_TYPE_HEADER ="Content-Type";
    
    public static final String ACCOUNT_HEADER = "X-oio-container-meta-sys-account";
    public static final String M2_CTIME_HEADER = "X-oio-container-meta-sys-m2-ctime";
    public static final String M2_INIT_HEADER = "X-oio-container-meta-sys-m2-init";
    public static final String M2_USAGE_HEADER = "X-oio-container-meta-sys-m2-usage";
    public static final String M2_VERSION_HEADER = "X-oio-container-meta-sys-m2-version";
    public static final String CONTAINER_SYS_NAME_HEADER = "X-oio-container-meta-sys-name";
    public static final String NS_HEADER = "X-oio-container-meta-sys-ns";
    public static final String TYPE_HEADER = "X-oio-container-meta-sys-type";
    public static final String USER_NAME_HEADER = "X-oio-container-meta-sys-user-name";
    public static final String SCHEMA_VERSION_HEADER = "X-oio-container-meta-x-schema-version";
    public static final String VERSION_MAIN_ADMIN_HEADER = "X-oio-container-meta-x-version-main-admin";
    public static final String VERSION_MAIN_ALIASES_HEADER = "X-oio-container-meta-x-version-main-aliases";
    public static final String VERSION_MAIN_CHUNKS_HEADER = "X-oio-container-meta-x-version-main-chunks";
    public static final String VERSION_MAIN_CONTENTS_HEADER = "X-oio-container-meta-x-version-main-contents";
    public static final String VERSION_MAIN_PROPERTIES_HEADER = "X-oio-container-meta-x-version-main-properties";

    public static final String CONTENT_META_ID_HEADER = "X-oio-content-meta-id";
    public static final String CONTENT_META_CHUNK_METHOD_HEADER = "X-oio-content-meta-chunk-method";
    public static final String CONTENT_META_CTIME_HEADER = "X-oio-content-meta-ctime";
    public static final String CONTENT_META_DELETED_HEADER = "X-oio-content-meta-deleted";
    public static final String CONTENT_META_HASH_HEADER = "X-oio-content-meta-hash";
    public static final String CONTENT_META_HASH_METHOD_HEADER = "X-oio-content-meta-hash-method";
    public static final String CONTENT_META_LENGTH_HEADER = "X-oio-content-meta-length";
    public static final String CONTENT_META_MIME_TYPE_HEADER = "X-oio-content-meta-mime-type";
    public static final String CONTENT_META_NAME_HEADER = "X-oio-content-meta-name";
    public static final String CONTENT_META_POLICY_HEADER = "X-oio-content-meta-policy";
    public static final String CONTENT_META_VERSION_HEADER = "X-oio-content-meta-version";

    public static final String NS_CHUNK_SIZE_HEADER = "X-oio-ns-chunk-size";
    public static final String LIST_TRUNCATED_HEADER = "X-oio-list-truncated";

    public static final String OIO_ACTION_MODE_HEADER = "X-oio-action-mode";

    /* -- RAWX common headers -- */
    
    public static final String CHUNK_META_CONTENT_ID = "X-oio-chunk-meta-content-id";
    public static final String CHUNK_META_CONTAINER_ID = "X-oio-chunk-meta-container-id";
    public static final String CHUNK_META_CONTENT_CHUNKSNB = "x-oio-chunk-meta-content-chunksnb";
    public static final String CHUNK_META_CONTENT_SIZE = "X-oio-chunk-meta-content-size";
    public static final String CHUNK_META_CONTENT_PATH = "X-oio-chunk-meta-content-path";
    public static final String CHUNK_META_CONTENT_POLICY = "X-oio-chunk-meta-content-storage-policy";
    public static final String CHUNK_META_CONTENT_CHUNK_METHOD = "X-oio-chunk-meta-content-chunk-method";
    public static final String CHUNK_META_CONTENT_MIME_TYPE = "X-oio-chunk-meta-content-mime-type";
    public static final String CHUNK_META_CHUNK_ID = "X-oio-chunk-meta-chunk-id";
    public static final String CHUNK_META_CHUNK_POS = "X-oio-chunk-meta-chunk-pos";
    public static final String CHUNK_META_CHUNK_HASH = "X-oio-chunk-meta-chunk-hash";
    
    /* -- Common parameters names -- */
    
    public static final String MAX_PARAM = "max";
    public static final String PREFIX_PARAM = "prefix";
    public static final String DELIMITER_PARAM = "delimiter";
    public static final String MARKER_PARAM = "marker";
    
    /* -- URL String format -- */
    
    /* -- CS -- */
    public static final String CS_NSINFO_FORMAT = "%s/v3.0/%s/conscience/info";
    public static final String CS_GETSRV_FORMAT = "%s/v3.0/%s/conscience/list?type=%s";
    public static final String CS_REGISTER_FORMAT = "%s/v3.0/%s/conscience/list?type=%s";
    
    /* -- DIR -- */
    public static final String DIR_REF_CREATE_FORMAT = "%s/v3.0/%s/reference/create?acct=%s&ref=%s";
    public static final String DIR_REF_DELETE_FORMAT = "%s/v3.0/%s/reference/destroy?acct=%s&ref=%s";
    public static final String DIR_REF_SHOW_FORMAT = "%s/v3.0/%s/reference/show?acct=%s&ref=%s";
    public static final String DIR_LINK_SRV_FORMAT = "%s/v3.0/%s/reference/link?acct=%s&ref=%s&type=%s";
    public static final String DIR_LIST_SRV_FORMAT = "%s/v3.0/%s/reference/show?acct=%s&ref=%s&type=%s";
    public static final String DIR_UNLINK_SRV_FORMAT = "%s/v3.0/%s/reference/unlink?acct=%s&ref=%s&type=%s";
    public static final String DIR_FORCE_SRV_FORMAT = "%s/v3.0/%s/reference/link?acct=%s&ref=%s";
    public static final String DIR_RENEW_SRV_FORMAT = "%s/v3.0/%s/reference/renew?acct=%s&ref=%s";
    
    /* -- STG -- */
    public static final String CREATE_CONTAINER_FORMAT = "%s/v3.0/NS/container/create?acct=%s&ref=%s";
    public static final String GET_CONTAINER_INFO_FORMAT = "%s/v3.0/%s/container/show?acct=%s&ref=%s";
    public static final String LIST_OBJECTS_FORMAT = "%s/v3.0/%s/container/list?acct=%s&ref=%s";
    public static final String DELETE_CONTAINER_FORMAT = "%s/v3.0/%s/container/destroy?acct=%s&ref=%s";
    public static final String GET_BEANS_FORMAT = "%s/v3.0/%s/content/prepare?acct=%s&ref=%s&path=%s";
    public static final String PUT_OBJECT_FORMAT = "%s/v3.0/%s/content/create?acct=%s&ref=%s&path=%s";
    public static final String GET_OBJECT_FORMAT = "%s/v3.0/%s/content/show?acct=%s&ref=%s&path=%s";
    public static final String DELETE_OBJECT_FORMAT = "%s/v3.0/%s/content/delete?acct=%s&ref=%s&path=%s";
    
    /* -- Common String format -- */
    public static final String INTERNAL_ERROR_FORMAT = "Internal error (%d %s)";
    public static final String UNMANAGED_ERROR_FORMAT = "Unmanaged response code (%d %s)";

    
}

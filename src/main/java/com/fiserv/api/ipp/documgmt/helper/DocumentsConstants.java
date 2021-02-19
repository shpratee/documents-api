package com.fiserv.api.ipp.documgmt.helper;

public interface DocumentsConstants {
    String APPLICATION_JSON_CONTENT_TYPE = "application/json";
    String ALLIANCE_CODE_HEADER = "Alliance-Code";
    String PARTNER_CODE_HEADER = "Partner-Code";
    String FISV_INTERACTION_ID_HEADER = "FISV-Interaction-Id";

    String ALLIANCE_CODE = "ALLIANCE_CODE";
    String PARTNER_CODE = "PARTNER_CODE";
    String INVOICE_REF = "INVOICE_REF";

    String XAPI_SOURCE_PLATFORM = "XAPI";

    String ALLIANCE_CODE_PARAM = "allianceCode";
    String PARTNER_CODE_PARAM = "partnerCode";
    String SOURCE_PLATFORM_PARAM = "sourcePlatform";
    String TYPE_PARAM = "type";

    String CORRELATION_ID_HEADER = "Correlation-Id";
    String CONTENT_TYPE_HEADER = "Content-Type";

    String SORT_PARAM = "sort";
    String OFFSET_PAGINATION_PARAM = "offset";
    String LIMIT_PAGINATION_PARAM = "limit";
    String CATEGORY_PARAM = "category";

    String TIMESTAMP_HEADER = "Timestamp";
    String AUTHORIZATION_HEADER = "Authorization";

    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
}

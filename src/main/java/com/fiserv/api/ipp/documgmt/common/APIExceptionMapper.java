package com.fiserv.api.ipp.documgmt.common;

import com.fiserv.api.ipp.documgmt.context.RequestContextHolder;
import com.fiserv.api.ipp.documgmt.exception.APIException;
import com.fiserv.api.ipp.documgmt.helper.DocumentsConstants;
import com.fiserv.api.ipp.documgmt.model.ErrorsType;
import com.fiserv.api.ipp.documgmt.service.DocumentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class APIExceptionMapper implements ExceptionMapper<APIException> {

    private static Logger logger = LoggerFactory.getLogger(APIExceptionMapper.class);

    @Override
    public Response toResponse(APIException e) {
        logger.error("Exception --->", e);

        return Response.status(e.getHttpStatus())
               .entity(new ErrorsType(e.getErrorType()))
               .type(MediaType.APPLICATION_JSON_TYPE)
               .header(DocumentsConstants.FISV_INTERACTION_ID_HEADER, RequestContextHolder.getContext().getInteractionId())
               .build();
    }
}

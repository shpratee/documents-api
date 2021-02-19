package com.fiserv.api.ipp.documgmt.common;

import com.fiserv.api.ipp.documgmt.context.RequestContextHolder;
import com.fiserv.api.ipp.documgmt.exception.InternalServerErrorException;
import com.fiserv.api.ipp.documgmt.helper.DocumentsConstants;
import com.fiserv.api.ipp.documgmt.model.ErrorType;
import com.fiserv.api.ipp.documgmt.model.ErrorsType;
import com.fiserv.api.ipp.documgmt.service.DocumentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private static Logger logger = LoggerFactory.getLogger(WebApplicationExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException e) {
        logger.error("Exception --->", e);

        return Response.serverError()
                .entity(new ErrorsType(InternalServerErrorException.DEFAULT_INTERNAL_SERVER_ERROR))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .header(DocumentsConstants.FISV_INTERACTION_ID_HEADER, RequestContextHolder.getContext().getInteractionId())
                .build();
    }
}

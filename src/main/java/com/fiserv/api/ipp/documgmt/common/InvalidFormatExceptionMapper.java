package com.fiserv.api.ipp.documgmt.common;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fiserv.api.ipp.documgmt.context.RequestContextHolder;
import com.fiserv.api.ipp.documgmt.exception.APIException;
import com.fiserv.api.ipp.documgmt.helper.DocumentsConstants;
import com.fiserv.api.ipp.documgmt.model.ErrorType;
import com.fiserv.api.ipp.documgmt.model.ErrorsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidFormatExceptionMapper implements ExceptionMapper<InvalidFormatException> {

    private static Logger logger = LoggerFactory.getLogger(InvalidFormatExceptionMapper.class);

    @Override
    public Response toResponse(InvalidFormatException e) {
        logger.error("Exception --->", e);

        ErrorsType errors = new ErrorsType(
                ErrorType.builder()
                        .setCode("BAD_REQUEST")
                        .setTitle(e.getOriginalMessage()).build());

        return Response.status(Response.Status.BAD_REQUEST)
               .entity(errors)
               .type(MediaType.APPLICATION_JSON_TYPE)
               .header(DocumentsConstants.FISV_INTERACTION_ID_HEADER, RequestContextHolder.getContext().getInteractionId())
               .build();
    }
}

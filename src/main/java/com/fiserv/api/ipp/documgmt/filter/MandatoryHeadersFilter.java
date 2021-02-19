package com.fiserv.api.ipp.documgmt.filter;

import com.fiserv.api.ipp.documgmt.context.RequestContextHolder;
import com.fiserv.api.ipp.documgmt.exception.BadRequestException;
import com.fiserv.api.ipp.documgmt.helper.DocumentsConstants;
import com.fiserv.api.ipp.documgmt.model.ErrorType;
import org.jose4j.lang.StringUtil;
import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

@Provider
@Priority(value = 11)
public class MandatoryHeadersFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String fisvInteractionId = containerRequestContext.getHeaderString(DocumentsConstants.FISV_INTERACTION_ID_HEADER);
        if(fisvInteractionId == null || "".equals(fisvInteractionId)){
            throw new BadRequestException(ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.FISV_INTERACTION_ID_HEADER)).setSourceHeader(DocumentsConstants.FISV_INTERACTION_ID_HEADER).build());
        } else {
            MDC.put("FSV-Interaction-Id", fisvInteractionId);
            RequestContextHolder.getContext().setInteractionId(fisvInteractionId);
        }

        String timestamp = containerRequestContext.getHeaderString(DocumentsConstants.TIMESTAMP_HEADER);
        if(timestamp == null || "".equals(timestamp)){
            System.out.print("Error Type built -> "+ ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.TIMESTAMP_HEADER)).setSourceHeader(DocumentsConstants.TIMESTAMP_HEADER).build());
            throw new BadRequestException(ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.TIMESTAMP_HEADER)).setSourceHeader(DocumentsConstants.TIMESTAMP_HEADER).build());
        }

        String authorization = containerRequestContext.getHeaderString(DocumentsConstants.AUTHORIZATION_HEADER);
        if(authorization == null || "".equals(authorization)){
            throw new BadRequestException(ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.AUTHORIZATION_HEADER)).setSourceHeader(DocumentsConstants.AUTHORIZATION_HEADER).build());
        } else {
            RequestContextHolder.getContext().setAuthToken(authorization);
        }

        String contentType = containerRequestContext.getHeaderString(DocumentsConstants.CONTENT_TYPE_HEADER);
        if("POST".equalsIgnoreCase(containerRequestContext.getMethod()) ||
                "PATCH".equalsIgnoreCase(containerRequestContext.getMethod()) ||
                "PUT".equalsIgnoreCase(containerRequestContext.getMethod()))   {
            if(contentType == null || "".equals(contentType)){
                throw new BadRequestException(ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.CONTENT_TYPE_HEADER)).setSourceHeader(DocumentsConstants.CONTENT_TYPE_HEADER).build());
            }
        }

        String allianceCode = containerRequestContext.getHeaderString(DocumentsConstants.ALLIANCE_CODE_HEADER);
        if(allianceCode == null || "".equals(allianceCode)){
            throw new BadRequestException(ErrorType.builder().setCode("BAD_REQUEST").setTitle(String.format("Mandatory Header %s is not present.",DocumentsConstants.ALLIANCE_CODE_HEADER)).setSourceHeader(DocumentsConstants.ALLIANCE_CODE_HEADER).build());
        }
    }
}

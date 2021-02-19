package com.fiserv.api.ipp.documgmt;

import com.fiserv.api.ipp.documgmt.helper.JWTValidator;
import com.fiserv.api.ipp.documgmt.model.CreateDocumentType;
import com.fiserv.api.ipp.documgmt.model.DocumentItemResponseType;
import com.fiserv.api.ipp.documgmt.model.Document;
import com.fiserv.api.ipp.documgmt.service.DocumentsService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/ipp/v1.0/documents")
@RequestScoped
public class DocumentsResource {

    private static Logger logger = LoggerFactory.getLogger(DocumentsResource.class);

    @Inject
    DocumentsService service;

    @Inject
    JWTValidator jwtValidator;

    @Inject
    JsonWebToken jwt;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response uploadDocument(@Valid CreateDocumentType document
            , @Context HttpHeaders httpHeaders
            , @Context SecurityContext securityContext){
        logger.debug("In Upload Document method");
        jwtValidator.validateJWT(jwt);

        return service.uploadDocument(document, httpHeaders);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveDocuments(
            @QueryParam("sort") String sort
            , @QueryParam("offset") String offset
            , @QueryParam("limit") String limit
            , @QueryParam("category") String category
            , @QueryParam("type") String type
            , @QueryParam("createdBefore") String createdBefore
            , @QueryParam("createdAfter") String createdAfter
            , @QueryParam("modifiedBefore") String modifiedBefore
            , @QueryParam("modifiedAfter") String modifiedAfter
            , @Context HttpHeaders httpHeaders
            , @Context SecurityContext securityContext){
        logger.debug("In Retrieve Documents method");
        jwtValidator.validateJWT(jwt);

        return service.retrieveDocuments(sort, offset, limit, category, type, createdBefore, createdAfter, modifiedBefore, modifiedAfter, httpHeaders);
    }

    @PUT
    @Path("/{documentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDocument(@PathParam("documentId") String documentId
            , Document document
            , @Context HttpHeaders httpHeaders
            , @Context SecurityContext securityContext){
        logger.debug("In Update Document method");
        jwtValidator.validateJWT(jwt);

        return service.updateDocument(documentId, document, httpHeaders);
    }

    @GET
    @Path("/{documentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveDocument(@PathParam("documentId") String documentId
            , @QueryParam("category") String category
            , @QueryParam("type") String type
            , @Context HttpHeaders httpHeaders
            , @Context SecurityContext securityContext){
        logger.debug("In Retrieve Documents method");
        jwtValidator.validateJWT(jwt);

        return service.retrieveDocument(category, documentId, type, httpHeaders);
    }
}
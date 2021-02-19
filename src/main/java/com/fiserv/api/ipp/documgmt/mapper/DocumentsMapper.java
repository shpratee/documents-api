package com.fiserv.api.ipp.documgmt.mapper;

import com.fiserv.api.ipp.documgmt.model.*;
import com.fiserv.api.ipp.documgmt.model.Document;
import com.fiserv.api.ipp.documgmt.model.client.*;
import com.fiserv.api.ipp.documgmt.model.client.Error;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class DocumentsMapper {
    public DocumentItemResponseType convertDocumentItemResponseToDocumentItemResponseType(DocumentItemResponse documentItemResponse, String category){
        DocumentItemResponseType docItemResponseType = new DocumentItemResponseType();
        docItemResponseType.setMeta(documentItemResponse.getMeta());
        docItemResponseType.setErrors(convertErrorsToErrorTypes(documentItemResponse.getErrors()));
        docItemResponseType.setData(convertDocumentToDocumentType(documentItemResponse.getData(), category));
        return docItemResponseType;
    }

    private ErrorsType convertErrorsToErrorTypes(Error[] errors) {
        if(errors != null && errors.length > 0){
            ErrorsType errorsType = new ErrorsType();
            //ErrorType[] errorsType = new ErrorType[errors.length];
            for(int i=0; i < errors.length; i++){
                ErrorType error = ErrorType.builder()
                        .setId(UUID.fromString(errors[i].getId()))
                        .setCode(errors[i].getCode())
                        .setDetail(errors[i].getCode())
                        .setTitle(errors[i].getTitle())
                        .setSourceParameter(errors[i].getSource() == null? null:errors[i].getSource().getParameter())
                        .setSourcePointer(errors[i].getSource() == null? null:errors[i].getSource().getPointer()).build();
                errorsType.add(error);
//                errorsType[i] = ErrorType.builder()
//                        .setId(UUID.fromString(errors[i].getId()))
//                        .setCode(errors[i].getCode())
//                        .setDetail(errors[i].getCode())
//                        .setTitle(errors[i].getTitle())
//                        .setSourceParameter(errors[i].getSource() == null? null:errors[i].getSource().getParameter())
//                        .setSourcePointer(errors[i].getSource() == null? null:errors[i].getSource().getPointer()).build();
            }
            return errorsType;
        }
        return null;
    }

    private Document convertDocumentToDocumentType(com.fiserv.api.ipp.documgmt.model.client.Document document, String category) {
        Document documentType = new Document();

        if(category == null || "meta".equals(category)) {
            documentType.setId(document.getId());
            documentType.setType(document.getType());
            documentType.setTitle(document.getTitle());
            documentType.setDescription(document.getDescription());
            documentType.setCreated(document.getCreated());
            documentType.setModified(document.getModified());
            documentType.setState(document.getState());
            documentType.setMeta(convertDomainFieldsToMeta(document.getDomainFields()));
        }

        System.out.println("Document Id -> "+ document.getId());
        documentType.setData(convertDocumentContentToDocumentData(document.getFileContent(), category));
        return documentType;
    }

    private Map convertDomainFieldsToMeta(DomainField[] domainFields) {
        if(domainFields != null && domainFields.length > 0){
            Map<String, String> meta = new HashMap();
            for(int i= 0; i < domainFields.length; i++){
                if("BOARDING_DOC_REF".equals(domainFields[i].getKey())){
                    meta.put("BOARDING_DOC_REF", domainFields[i].getValue());
                } else if("FINANCIAL_REF_NUM".equals(domainFields[i].getKey())){
                    meta.put("FINANCIAL_REF_NUM", domainFields[i].getValue());
                } else if("INVOICE_REF".equals(domainFields[i].getKey())){
                    meta.put("INVOICE_REF", domainFields[i].getValue());
                }
            }

            return meta.size() > 0 ? meta : null;
        }

        return null;
    }

    private DocumentData convertDocumentContentToDocumentData(DocumentContent documentContent, String category) {
        DocumentData docData = new DocumentData();

        if(documentContent != null) {
            docData.setName(documentContent.getFileName());

            if (!"meta".equals(category)) {
                docData.setContent(documentContent.getFileContent());
            }
        }

        return docData;
    }

    public DocumentCollectionResponseType convertDocumentCollectionResponseToDocumentCollectionResponseType(DocumentCollectionResponse documentCollectionResponse, String category) {
        if(documentCollectionResponse != null){
            DocumentCollectionResponseType documentCollectionResponseType = new DocumentCollectionResponseType();

            if(documentCollectionResponse.getData() != null){
                com.fiserv.api.ipp.documgmt.model.client.Document[] documents = documentCollectionResponse.getData();
                Document[] documentsType = new Document[documents.length];

                for(int i =0; i < documents.length; i++){
                    documentsType[i] = convertDocumentToDocumentType(documents[i], category);
                }

                documentCollectionResponseType.setData(documentsType);
            }

            documentCollectionResponseType.setMeta(documentCollectionResponse.getMeta());
            documentCollectionResponseType.setErrors(convertErrorsToErrorTypes(documentCollectionResponse.getErrors()));



            return documentCollectionResponseType;
        }

        return null;
    }

    public void convertMetaToDomainFields(List<DomainField> domainFields, Map<String, String> metaMap) {
        for (Map.Entry<String,String> entry : metaMap.entrySet()) {
            domainFields.add(new DomainField(entry.getKey(), entry.getValue()));
        }
    }
}
package com.fiserv.api.ipp.documgmt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiserv.api.ipp.documgmt.model.ErrorType;
import com.fiserv.api.ipp.documgmt.model.client.Document;
import com.fiserv.api.ipp.documgmt.model.client.DocumentCollectionResponse;
import com.fiserv.api.ipp.documgmt.model.client.DocumentItemResponse;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
//        String json = "{\"meta\":{\"paging\":{\"count\":640,\"totalPages\":32,\"currentOffset\":0,\"currentNumberOfRetrievedRecords\":20,\"hasMoreRecords\":true,\"pageNumber\":0},\"sorting\":{}},\"data\":[{\"d" +
//                "ocumentId\":\"85d7cfad-e95b-4f92-be96-983053d6751a\",\"documentType\":\"IDENTIFICATION\",\"documentTitle\":\"Some title\",\"documentDescription\":null,\"documentState\":\"ACTIVE\",\"documentCreated\":\"2020-08-04T11:51:48.375Z\",\"documentModified\":\"2020-08-04T11:53:43.15Z\",\"fi" +
//                "leContent\":{\"fileContent\":null,\"fileName\":\"someFilename\"},\"domainFields\":[{\"key\":\"DOCUMENT_REF_NUM\",\"value\":null},{\"key\":\"CLOSE_DATE\",\"value\":null},{\"key\":\"REQUEST_TYPE\",\"value\":null},{\"key\":\"DOCUMENT_SUBTYPE\",\"value\":null},{\"key\":\"BOARDING_DOC_REF\",\"value\":" +
//                "\"af21650d-6f84-4dfb-a016-e07f438e46c6\"},{\"key\":\"PARTNER_CODE\",\"value\":null},{\"key\":\"ALLIANCE_CODE\",\"value\":\"RBS\"},{\"key\":\"EXTERNAL_MERCH_ID\",\"value\":null},{\"key\":\"INTERNAL_MERCH_ID\",\"value\":null},{\"key\":\"GENERATION_DATE\",\"value\":null},{\"key\":\"SOURCE_REF_NU" +
//                "M\",\"value\":null},{\"key\":\"OBSOLETE\",\"value\":\"false\"}]}]}";
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.configure(SerializationFeature.CLOSE_CLOSEABLE, true);
//        mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
//        // Allow unknown properties. This will help to avoid conflicts between Gaffer versions.
//       mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        // Using the deprecated version for compatibility with older versions of jackson
//       mapper.registerModule(new JavaTimeModule());
//
//        DocumentCollectionResponse response = mapper.readValue(json, DocumentCollectionResponse.class);
//        System.out.println("Response: "+response);
//
//        if(response.getData()[0].getFileContent().getFileContent() != null){
//            System.out.println("Works");
//        }
//
//
//
//        Document doc = new Document();
//        doc.setDescription("Description");
//        doc.setId("qwertyuio");
//        doc.setType("FINANCIAL");
//
//        Document[] documents = new Document[]{doc};
//
//
//        System.out.println("Json String: "+ mapper.writeValueAsString(documents));

       ErrorType error =  ErrorType.builder().setCode("BAD_REQUEST").setTitle("Wrong Title").setSourceParameter("sort").setSourcePointer("/data/id").setSourceHeader("Alliance-Code").build();
       System.out.println("Error "+error);
    }
}

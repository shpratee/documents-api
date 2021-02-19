package com.fiserv.api.ipp.documgmt.model;

public class DocumentCollectionResponseType extends ResponseType {

    public Document[] getData() {
        return data;
    }
    public void setData(Document[] data) {
        this.data = data;
    }

    private Document[] data;
}
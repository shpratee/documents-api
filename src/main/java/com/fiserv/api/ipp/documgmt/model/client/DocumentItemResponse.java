package com.fiserv.api.ipp.documgmt.model.client;

public class DocumentItemResponse extends Response {
    public Document getData() {
        return data;
    }

    public void setData(Document data) {
        this.data = data;
    }

    private Document data;
}

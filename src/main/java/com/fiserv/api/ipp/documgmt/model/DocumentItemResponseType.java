package com.fiserv.api.ipp.documgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiserv.api.ipp.documgmt.model.client.Response;

public class DocumentItemResponseType extends ResponseType {

    public Document getData() {
        return data;
    }
    public void setData(Document data) {
        this.data = data;
    }

    private Document data;
}

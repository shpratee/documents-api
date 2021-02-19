package com.fiserv.api.ipp.documgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseType {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map getMeta() {
        return meta;
    }

    public void setMeta(Map meta) {
        this.meta = meta;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ErrorsType getErrors() {
        return errors;
    }

    public void setErrors(ErrorsType errors) {
        this.errors = errors;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map meta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorsType errors;
}

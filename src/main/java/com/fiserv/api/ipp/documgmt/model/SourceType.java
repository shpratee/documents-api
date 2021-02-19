package com.fiserv.api.ipp.documgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceType {
    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public SourceType(String pointer, String parameter, String header){
        this.pointer = pointer;
        this.parameter = parameter;
        this.header = header;
    }

    public SourceType(){}

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String pointer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String parameter;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String header;

    @Override
    public String toString() {
        return
        "{" +
            "\"pointer\": \""+this.pointer+"\","+
            "\"parameter\": \""+this.parameter+"\","+
            "\"header\": \""+this.header+"\""+
        "}";
    }
}

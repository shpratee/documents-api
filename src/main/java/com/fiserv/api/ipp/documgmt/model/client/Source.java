package com.fiserv.api.ipp.documgmt.model.client;

public class Source {
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

    private String pointer;
    private String parameter;
}

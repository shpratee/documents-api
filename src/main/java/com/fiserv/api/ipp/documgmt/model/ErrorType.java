package com.fiserv.api.ipp.documgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorType {
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String description) {
        this.detail = detail;
    }

    public SourceType getSource() {
        return source;
    }
    public void setSource(SourceType source) {
        this.source = source;
    }

    public ErrorType(){}
    protected ErrorType(ErrorTypeBuilder builder) {
        this.id = builder.getId();
        this.code = builder.getCode();
        this.title = builder.getTitle();
        this.detail = builder.getDetail();

        if(builder.getSourceParameter() != null || builder.getSourcePointer() != null || builder.getSourceHeader() != null) {
            if (this.source == null) {
                source = new SourceType();
            }

            this.source.setParameter(builder.getSourceParameter());
            this.source.setPointer(builder.getSourcePointer());
            this.source.setHeader(builder.getSourceHeader());
        }
    }

    public static ErrorTypeBuilder builder() {
        return new ErrorTypeBuilder(UUID.randomUUID());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private UUID id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String detail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private SourceType source;

    @Override
    public String toString() {
        return
        "{" +
            "\"id\": \""+this.id+"\","+
            "\"code\": \""+this.code+"\","+
            "\"title\": \""+this.title+"\","+
            "\"source\":"+this.source+
        "}";
    }
}

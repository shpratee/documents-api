package com.fiserv.api.ipp.documgmt.model;

import com.fiserv.api.ipp.documgmt.validations.DocumentTypeSubset;
import com.fiserv.api.ipp.documgmt.validations.EnumValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class CreateDocumentType {

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentData getData() {
        return data;
    }
    public void setData(DocumentData data) {
        this.data = data;
    }

    public Map getMeta() {
        return meta;
    }
    public void setMeta(Map meta) {
        this.meta = meta;
    }

    public DocumentTypeEnum getType() {
        return type;
    }
    public void setType(DocumentTypeEnum type) {
        this.type = type;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Length(max = 2000, message = "Length of field description must be between 5 and 2000.")
    private String description;

    @Valid
    @NotNull(message  = "Document data must not be missing.")
    private DocumentData data;
    private Map meta;

    @Valid
    @NotNull(message = "Field type must not be missing.")
    @DocumentTypeSubset(anyOf = {DocumentTypeEnum.FINANCIAL, DocumentTypeEnum.CONTRACT, DocumentTypeEnum.IDENTIFICATION, DocumentTypeEnum.OTHER})
    private DocumentTypeEnum type;

    @NotBlank(message = "Field title must not be missing.")
    @Length(min = 1, max = 255, message = "Length of Document title must be between 1 and 255. ")
    private String title;
}

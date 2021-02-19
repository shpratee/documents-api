package com.fiserv.api.ipp.documgmt.model.client;

import java.time.OffsetDateTime;

public class SearchDocumentRequest {

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public OffsetDateTime getCreatedAfter() {
        return createdAfter;
    }

    public void setCreatedAfter(OffsetDateTime createdAfter) {
        this.createdAfter = createdAfter;
    }

    public OffsetDateTime getCreatedBefore() {
        return createdBefore;
    }

    public void setCreatedBefore(OffsetDateTime createdBefore) {
        this.createdBefore = createdBefore;
    }

    public OffsetDateTime getModifiedAfter() {
        return modifiedAfter;
    }

    public void setModifiedAfter(OffsetDateTime modifiedAfter) {
        this.modifiedAfter = modifiedAfter;
    }

    public OffsetDateTime getModifiedBefore() {
        return modifiedBefore;
    }

    public void setModifiedBefore(OffsetDateTime modifiedBefore) {
        this.modifiedBefore = modifiedBefore;
    }

    public DomainField[] getDomainFields() {
        return domainFields;
    }

    public void setDomainFields(DomainField[] domainFields) {
        this.domainFields = domainFields;
    }

    private String documentTitle;
    private String documentType;
    private OffsetDateTime createdAfter;
    private OffsetDateTime createdBefore;
    private OffsetDateTime modifiedAfter;
    private OffsetDateTime modifiedBefore;
    private DomainField[] domainFields;
}

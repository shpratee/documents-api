package com.fiserv.api.ipp.documgmt.model;

import java.time.OffsetDateTime;
import java.util.Map;

public class Document {

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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public OffsetDateTime getCreated() {
        return created;
    }
    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getModified() {
        return modified;
    }
    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public String getState() {
        return state;
    }
    public void setState(String status) {
        this.state = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String description;
    private DocumentData data;
    private Map meta;
    private String type;
    private String title;
    private OffsetDateTime created;
    private OffsetDateTime modified;
    private String state;
}

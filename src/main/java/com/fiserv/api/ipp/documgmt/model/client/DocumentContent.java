package com.fiserv.api.ipp.documgmt.model.client;

public class DocumentContent {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public  String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    private String fileName;
    private String fileContent;
}

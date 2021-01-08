package com.example.raciociniobruto;

public class DocumentCase {
    private String json;
    private String identifier;

    public DocumentCase() {
    }

    public DocumentCase(String json, String identifier) {
        this.json = json;
        this.identifier = identifier;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
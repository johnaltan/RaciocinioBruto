package com.example.raciociniobruto;

import java.util.List;

public class DocumentCaseList {
    private List<DocumentCase> caseList;

    public DocumentCaseList() {
    }

    public DocumentCaseList(List<DocumentCase> caseList) {
        this.caseList = caseList;
    }

    public List<DocumentCase> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<DocumentCase> caseList) {
        this.caseList = caseList;
    }
}

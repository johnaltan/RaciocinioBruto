package com.example.raciociniobruto;


import java.util.ArrayList;

public interface ClinicalCaseTransfer {

    public ArrayList<ClinicalCase> loadCases ();
    public void sendCases (ArrayList<ClinicalCase> clinicalCases);
}

package com.example.raciociniobruto;


import android.net.Uri;

import java.util.ArrayList;

public interface ClinicalCaseTransfer {

    public ArrayList<ClinicalCase> loadCases (Uri uri);
    public void sendCases (ArrayList<ClinicalCase> clinicalCases, Uri uri);
}

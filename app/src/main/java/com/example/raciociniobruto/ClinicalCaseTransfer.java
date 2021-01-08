package com.example.raciociniobruto;


import android.net.Uri;

import java.util.ArrayList;

public interface ClinicalCaseTransfer {

    public void loadCases (Uri uri, OnLoadClinicalCasesListener transListener);
    public void sendCases (ArrayList<ClinicalCase> clinicalCases, Uri uri);
}

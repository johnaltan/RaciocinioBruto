package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClinicalCase {
    private Disease[] disease;


    private Stage anamnesis;
    private Stage physicalExam;
    private Stage complementaryExam;

    public ClinicalCase() {
    }

    public ClinicalCase(Stage anamnesis, Disease[] disease, Stage physicalExam, Stage complementaryExam) {
        this.anamnesis = anamnesis;
        this.disease = disease;
        this.physicalExam = physicalExam;
        this.complementaryExam = complementaryExam;
    }

    public Stage getAnamnesis() {
        return anamnesis;
    }

    public Disease[] getDisease() {
        return disease;
    }

    public Stage getPhysicalExam() {
        return physicalExam;
    }

    public Stage getComplementaryExam() {
        return complementaryExam;
    }
}

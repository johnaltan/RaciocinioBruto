package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClinicalCase {
    private Disease[] disease;


    private StageBean anamnesis;
    private StageBean physicalExam;
    private StageBean complementaryExam;

    public ClinicalCase() {
    }

    public ClinicalCase(StageBean anamnesis, Disease[] disease, StageBean physicalExam, StageBean complementaryExam) {
        this.anamnesis = anamnesis;
        this.disease = disease;
        this.physicalExam = physicalExam;
        this.complementaryExam = complementaryExam;
    }

    public StageBean getAnamnesis() {
        return anamnesis;
    }

    public Disease[] getDisease() {
        return disease;
    }

    public StageBean getPhysicalExam() {
        return physicalExam;
    }

    public StageBean getComplementaryExam() {
        return complementaryExam;
    }
}

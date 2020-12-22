package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClinicalCase {
    private Anamnesis anamnesis;
    private Disease[] disease;
    private PhysicalExam physicalExam;
    private ComplementaryExam complementaryExam;

    public ClinicalCase() {
    }

    public ClinicalCase(Anamnesis anamnesis, Disease[] disease, PhysicalExam physicalExam, ComplementaryExam complementaryExam) {
        this.anamnesis = anamnesis;
        this.disease = disease;
        this.physicalExam = physicalExam;
        this.complementaryExam = complementaryExam;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public Disease[] getDisease() {
        return disease;
    }

    public PhysicalExam getPhysicalExam() {
        return physicalExam;
    }

    public ComplementaryExam getComplementaryExam() {
        return complementaryExam;
    }
}

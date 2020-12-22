package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClinicalCase implements Transferable {
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

    @Override
    public JSONObject toJSONObject() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("anamnesis",this.anamnesis.toJSONObject());
        object.put("disease",this.disease); //TODO
        object.put("physicalExam",this.physicalExam.toJSONObject());
        object.put("complementaryExam",this.complementaryExam.toJSONObject());
        return object;
    }

    @Override
    public Transferable fromJSONObject(JSONObject jsonObject) throws JSONException {
        ClinicalCase clinicalCase = new ClinicalCase();

        clinicalCase.anamnesis = (Anamnesis) jsonObject.get("anamnesis");
        clinicalCase.disease = (Disease[]) jsonObject.get("disease");
        clinicalCase.physicalExam = (PhysicalExam) jsonObject.get("physicalExam");
        clinicalCase.complementaryExam = (ComplementaryExam) jsonObject.get("complementaryExam");

        return clinicalCase;
    }
}

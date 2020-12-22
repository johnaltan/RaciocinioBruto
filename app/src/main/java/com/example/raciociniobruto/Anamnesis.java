package com.example.raciociniobruto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Anamnesis extends Stage implements Transferable{
    private StageItem name;
    private StageItem age;
    private StageItem sex;
    private StageItem profession;
    private StageItem CC; //QP
    private StageItem HPI; //HDA
    private StageItem ROS; //ISDAS
    private StageItem PMH; //HMP
    private StageItem FD; //HMF
    private StageItem SH; //HFS

    public Anamnesis() {

    }

    public Anamnesis(String stageName, StageItem name, StageItem age, StageItem sex, StageItem profession,
                     StageItem CC, StageItem HPI, StageItem ROS, StageItem PMH, StageItem FD, StageItem SH) {

        this.name = name;
        this.age = age;
        this.sex = sex;
        this.profession = profession;
        this.CC = CC;
        this.HPI = HPI;
        this.ROS = ROS;
        this.PMH = PMH;
        this.FD = FD;
        this.SH = SH;

        super.setName(stageName);
        super.addAvailableStageItem(name);
        super.addAvailableStageItem(age);
        super.addAvailableStageItem(profession);
        super.addAvailableStageItem(CC);
        super.addAvailableStageItem(HPI);
        super.addAvailableStageItem(ROS);
        super.addAvailableStageItem(PMH);
        super.addAvailableStageItem(FD);
        super.addAvailableStageItem(SH);

        super.addStageItemSummary(name);
        super.addStageItemSummary(age);
        super.addStageItemSummary(sex);
        super.addStageItemSummary(CC);
        super.addStageItemSummary(HPI);
    }

    @Override
    public JSONObject toJSONObject() throws JSONException {
        JSONObject object = new JSONObject();

        object.put("name",this.name.toJSONObject());
        object.put("age",this.age.toJSONObject());
        object.put("profession",this.profession.toJSONObject());
        object.put("CC",this.CC.toJSONObject());
        object.put("HPI",this.HPI.toJSONObject());
        object.put("ROS",this.ROS.toJSONObject());
        object.put("PMH",this.PMH.toJSONObject());
        object.put("FD",this.FD.toJSONObject());
        object.put("SH",this.SH.toJSONObject());

        /*
        object.put("stageName",super.getName());
        object.put("availableStageItems",super.generateJSONArrayObject(super.getAvailableStageItems()));
        object.put("stageItemOptions",super.generateJSONArrayObject(super.getStageItemOptions()));
        object.put("stageItemSummary",super.generateJSONArrayObject(super.getStageItemSummary()));
        object.put("askedStageItems",super.generateJSONArrayObject(super.getAskedStageItems()));*/

        return object;
    }

    @Override
    public Transferable fromJSONObject(JSONObject jsonObject) throws JSONException {
        Anamnesis anamnesis = new Anamnesis();

        anamnesis.name = (StageItem)jsonObject.get("name");
        anamnesis.age = (StageItem)jsonObject.get("age");
        anamnesis.profession = (StageItem)jsonObject.get("profession");
        anamnesis.CC = (StageItem)jsonObject.get("CC");
        anamnesis.HPI = (StageItem)jsonObject.get("HPI");
        anamnesis.ROS = (StageItem)jsonObject.get("ROS");
        anamnesis.PMH = (StageItem)jsonObject.get("PMH");
        anamnesis.FD = (StageItem)jsonObject.get("FD");
        anamnesis.SH = (StageItem)jsonObject.get("SH");

        return anamnesis;
    }





}

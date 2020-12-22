package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

public class Anamnesis extends Stage {
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

        super.setStageName(stageName);
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
}

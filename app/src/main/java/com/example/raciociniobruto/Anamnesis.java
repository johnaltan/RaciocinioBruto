package com.example.raciociniobruto;

import java.util.HashMap;
import java.util.Set;

public class Anamnesis extends Stage{
    private StageItem Name;
    private StageItem Age;
    private StageItem Sex;
    private StageItem Profession;
    private StageItem CC; //QP
    private StageItem HPI; //HDA
    private StageItem ROS; //ISDAS
    private StageItem PMH; //HMP
    private StageItem FD; //HMF
    private StageItem SH; //HFS

    public Anamnesis() {

    }

    public Anamnesis(StageItem name, StageItem age, StageItem sex, StageItem profession,
                     StageItem CC, StageItem HPI, StageItem ROS, StageItem PMH, StageItem FD, StageItem SH) {

        this.Name = name;
        this.Age = age;
        this.Sex = sex;
        this.Profession = profession;
        this.CC = CC;
        this.HPI = HPI;
        this.ROS = ROS;
        this.PMH = PMH;
        this.FD = FD;
        this.SH = SH;

        super.addStageItem(name);
        super.addStageItem(age);
        super.addStageItem(profession);
        super.addStageItem(CC);
        super.addStageItem(HPI);
        super.addStageItem(ROS);
        super.addStageItem(PMH);
        super.addStageItem(FD);
        super.addStageItem(SH);

        super.addStageItemSummary(name);
        super.addStageItemSummary(age);
        super.addStageItemSummary(CC);
        super.addStageItemSummary(HPI);
    }




}

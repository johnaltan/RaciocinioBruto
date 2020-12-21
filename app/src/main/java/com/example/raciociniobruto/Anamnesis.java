package com.example.raciociniobruto;

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

    public Anamnesis(String stageName, StageItem name, StageItem age, StageItem sex, StageItem profession,
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




}

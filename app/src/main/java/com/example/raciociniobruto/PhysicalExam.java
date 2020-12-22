package com.example.raciociniobruto;

public class PhysicalExam extends Stage {

    public PhysicalExam (){
        super.setName("Exame fisico");
        StageItem ssvv = new StageItem("SSVV","PA: 120 mmHg; T: 36,5 ºC; FC: 80 bpm; FR: 18 irpm");
        super.addStageItemSummary(ssvv);
        super.addAvailableStageItem(ssvv);
        super.addAvailableStageItem(new StageItem("AC","RCR 2T BNF SS"));

    }
}

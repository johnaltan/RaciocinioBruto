package com.example.raciociniobruto;

import java.util.ArrayList;

public class Scene {
    private ClinicalCase clinicalCase;
    private Stage stages[];
    private int step;
    private int stagePos;

    public Scene (ClinicalCase clinicalCase){
        this.clinicalCase = clinicalCase;
        this.stages = new Stage[4];
        this.stages[0] = new Stage("Anamnese",clinicalCase.getAnamnesis());
        this.stages[1] = new Stage ("Exame físico",clinicalCase.getPhysicalExam());
        this.stages[2] = new Stage ("Exames complementares",clinicalCase.getComplementaryExam());
        this.step = 0;
        this.stagePos = 0;
    }

    public void nextStep(){
        this.step++;
    }

    public void nextStage() { this.stagePos++; }

    public int getStep(){
        return this.step;
    }

    public String askItem(String info){
        String askedInfo = this.stages[stagePos].askItem(info);
        if (askedInfo == null) askedInfo = "Info inexistente";
        nextStep();
        return askedInfo;
    }

    public String findAskedItemValue (String itemName){
        return this.stages[stagePos].findAskedItemValue(itemName);
    }

    public ArrayList<String> nameAskedFoundItems (){
        return this.stages[stagePos].nameAskedFoundItems();
    }

    public ArrayList<String> nameNotFoundItems(){
        return this.stages[stagePos].nameNotFoundItems();
    }

    public String getStageSummary (){
        String stageSummaryText = new String();
        ArrayList<String> items = this.stages[stagePos].getItemsSummaryNames();
        for (String i : items)
            stageSummaryText += i + ": " + this.stages[stagePos].findSummaryItemValue(i) + "\n";
        return stageSummaryText;
    }

    public String getStageName (){
        return this.stages[stagePos].getName();
    }

    public void setStagePos(int stagePos) {this.stagePos = stagePos;}

}

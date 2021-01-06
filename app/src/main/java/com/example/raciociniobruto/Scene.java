package com.example.raciociniobruto;

import java.util.ArrayList;

public class Scene {
    private ClinicalCase clinicalCase;
    private Stage stages[];
    private int step;
    private int stagePos;
    private int globalAvailableItemsAmount;

    public Scene (ClinicalCase clinicalCase){
        this.clinicalCase = clinicalCase;
        this.stages = new Stage[3];
        this.stages[0] = new Stage("Anamnese",clinicalCase.getAnamnesis());
        this.stages[1] = new Stage ("Exame físico",clinicalCase.getPhysicalExam());
        this.stages[2] = new Stage ("Exames complementares",clinicalCase.getComplementaryExam());
        this.step = 0;
        this.stagePos = 0;
        this.calculateGlobalAvailableItemsAmount();
    }

    public void nextStep(){
        this.step++;
    }

    public void nextStage() {
        this.stagePos++;
        if (stagePos >= stages.length) stagePos = 0;
    }
    public void previousStage() {
        this.stagePos--;
        if (stagePos < 0) stagePos = stages.length - 1;
    }

    public int getStep(){
        return this.step;
    }

    public StageItem askItem(String info){
        StageItem askedInfo = this.stages[stagePos].askItem(info);
        nextStep();
        return askedInfo;
    }

    public String findAskedItemValue (String itemName){
        return this.stages[stagePos].findAskedItemValue(itemName);
    }

    public ArrayList<String> nameAskedFoundItems (){
        return this.stages[stagePos].nameAskedFoundItems();
    }

    public ArrayList<StageItem> getAskedFoundItems(){
        return this.stages[stagePos].getAskedFoundItems();
    }

    public ArrayList<String> nameNotFoundItems(){
        return this.stages[stagePos].nameNotFoundItems();
    }


    public ArrayList<StageItem> getNotFoundItems(){
        return this.stages[stagePos].getNotFoundItems();
    }


    public String getStageSummary (){

        return this.stages[stagePos].getSummary();
    }

    public String getStageName (){
        return this.stages[stagePos].getName();
    }

    public void setStagePos(int stagePos) {this.stagePos = stagePos;}

    public void calculateGlobalAvailableItemsAmount(){
        this.globalAvailableItemsAmount = 0;
        for(int i = 0; i < this.stages.length;i++) this.globalAvailableItemsAmount += this.stages[i].informAvailableItemsAmount();
    }

    public int getGlobalAvailableItemsAmount() {
        return globalAvailableItemsAmount;
    }
}

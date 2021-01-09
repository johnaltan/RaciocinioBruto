package com.example.raciociniobruto;

import java.util.ArrayList;

public class Scene {

    public static final int MOVE_FOWARD = 1;
    public static final int MOVE_BACKWARD = -1;

    private ClinicalCase clinicalCase;
    private Stage stages[];
    private int step;
    private int stagePos;
    private int globalAvailableItemsAmount;
    private ArrayList<String> triedHypothesis;

    public Scene (ClinicalCase clinicalCase){
        this.triedHypothesis = new ArrayList<String>();
        this.clinicalCase = clinicalCase;
        this.stages = new Stage[3];
        this.stages[0] = new Stage("Anamnese",clinicalCase.getAnamnesis());
        this.stages[1] = new Stage ("Exame físico",clinicalCase.getPhysicalExam());
        this.stages[2] = new Stage ("Exames complementares",clinicalCase.getComplementaryExam());
        this.step = 0;
        this.stagePos = 0;
        this.calculateGlobalAvailableItemsAmount();
    }

    public boolean tryToDiagnose(String inquiryHypothesis) {
        for(Disease d : this.clinicalCase.getDiseases()) if(d.isCorrectDiagnosis(inquiryHypothesis)) return true;
        triedHypothesis.add(inquiryHypothesis);
        return false;
    }

    public ArrayList<String> getTriedHypothesis(){
        return this.triedHypothesis;
    }

    public void advanceSteps(int steps){
        this.step += steps;
    }

    public void moveOneStageFrom(int previousStage, int direction){
        this.stagePos = previousStage;
        if(direction > 0) nextStage();
        else previousStage();
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

    public ArrayList<StageItem> askItem(String info){
        ArrayList<StageItem> askedInfos = this.stages[stagePos].askItem(info);
        if (askedInfos.size() <= 1) advanceSteps(1);
        return askedInfos;
    }

    public void saveTempFoundItemsIndexes(ArrayList<Integer> indexesToSave){
        this.stages[stagePos].saveTempFoundItemsIndexes(indexesToSave);
        advanceSteps(indexesToSave.size());
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

    public int getStagePos(){
        return this.stagePos;
    }

    public void calculateGlobalAvailableItemsAmount(){
        this.globalAvailableItemsAmount = 0;
        for(int i = 0; i < this.stages.length;i++) this.globalAvailableItemsAmount += this.stages[i].informAvailableItemsAmount();
    }

    public int getGlobalAvailableItemsAmount() {
        return globalAvailableItemsAmount;
    }

    public Stage[] getStages() {
        return stages;
    }

    public void setStages(Stage[] stages) {
        this.stages = stages;
    }
}

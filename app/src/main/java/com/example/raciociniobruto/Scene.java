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
        this.stages[0] = clinicalCase.getAnamnesis();
        this.stages[1] = clinicalCase.getPhysicalExam();
        this.stages[2] = clinicalCase.getComplementaryExam();
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

    public String askInfo(String info){
        String askedInfo = this.stages[stagePos].askInfo(info);
        if (askedInfo == null) askedInfo = new String("Info inexistente");
        nextStep();
        return askedInfo;
    }

    public ArrayList<String> nameInfoOptions(){
        return this.stages[stagePos].nameInfoOptions();
    }

    public ArrayList<String> nameAskedInfos (){
        return this.stages[stagePos].nameAskedInfos();
    }

    public String getStageSummary (){
        String stageSummaryText = new String();
        ArrayList<StageItem> items = this.stages[stagePos].getSummaryItems();
        for (int i = 0; i < items.size(); i++)
            stageSummaryText += items.get(i).getName() + ": " + items.get(i).getValue() + "\n";
        return stageSummaryText;
    }

    public String getStageName (){
        return this.stages[stagePos].getName();
    }

    public ArrayList<StageItem> getStageItems (){
        return this.stages[stagePos].getAskedItems();
    }
}

package com.example.raciociniobruto;

import java.util.ArrayList;
import java.util.Set;

public class Scene {
    ClinicalCase ClinicalCase;
    Stage stages[];
    int step;

    public void loadCase(ClinicalCase clinicalCase){
        this.ClinicalCase = clinicalCase;
        this.stages = new Stage[4];
        this.stages[0] = clinicalCase.getAnamnesis();
        this.stages[1] = clinicalCase.getPhysicalExam();
        this.stages[2] = clinicalCase.getComplementaryExam();
        this.step = 0;
    }

    public void nextStep(){
        this.step++;
    }

    public String askInfo(String info){
        return this.stages[step].getInfo(info);
    }

    public ArrayList<String> getInfoOptions (){
        return this.stages[step].getInfoOptions();
    }

    public String getStageSummary (){
        String stageSummaryText = new String();
        ArrayList<StageItem> items = this.stages[step].getSummaryItems();
        for (int i = 0; i < items.size(); i++)
            stageSummaryText += items.get(i).getName() + ": " + items.get(i).getValue() + "\n";
        return stageSummaryText;
    }
}

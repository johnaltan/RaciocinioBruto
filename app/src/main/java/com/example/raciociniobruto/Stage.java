package com.example.raciociniobruto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Stage {
    private String name;
    private ArrayList<StageItem> info;
    private ArrayList<StageItem> stageItemSummary;

    public Stage() {
        this.info = new ArrayList<StageItem>();
        this.stageItemSummary = new ArrayList<StageItem>();
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return this.name;
    }
    public String getInfo(String info){
        String value = null;
        for (int i = 0; i < this.info.size(); i++)
            if(this.info.get(i).getName().equals(info)){
                value = this.info.get(i).getValue();
                break;
            }
        return value;
    }

    public ArrayList<String> getInfoOptions() {
        ArrayList<String> infoOptions = new ArrayList<String>();
        for (int i = 0; i < this.info.size(); i++) infoOptions.add(this.info.get(i).getName());
        return infoOptions;
    }

    public ArrayList<StageItem> getSummaryItems (){
        return this.stageItemSummary;
    }

    public void addStageItem (StageItem newItem){
        this.info.add(newItem);
    }

    public void addStageItemSummary (StageItem newItem){
        this.stageItemSummary.add(newItem);
    }


}

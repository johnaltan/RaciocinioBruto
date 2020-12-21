package com.example.raciociniobruto;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<StageItem> availableStageItems;
    private ArrayList<StageItem> stageItemOptions;
    private ArrayList<StageItem> stageItemSummary;
    private ArrayList<StageItem> askedStageItems;

    public Stage() {
        this.availableStageItems = new ArrayList<StageItem>();
        this.stageItemSummary = new ArrayList<StageItem>();
        this.stageItemOptions = new ArrayList<StageItem>();
        this.askedStageItems = new ArrayList<StageItem>();

    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return this.name;
    }

    public String getInfo(String info){
        String value = null;
        for (StageItem i : availableStageItems)
            if(i.getName().equalsIgnoreCase(info)){
                value = i.getValue();
                askedStageItems.add(i);
                break;
            }
        return value;
    }

    public ArrayList<String> getStageItemOptions() {
        ArrayList<String> infoOptions = new ArrayList<String>();
        for (StageItem i : this.stageItemOptions) infoOptions.add(i.getName());
        return infoOptions;
    }

    public ArrayList<StageItem> getSummaryItems (){
        return this.stageItemSummary;
    }

    public void addAvailableStageItem(StageItem newItem){
        this.availableStageItems.add(newItem);
    }

    public void addStageItemSummary (StageItem newItem){
        this.stageItemSummary.add(newItem);
    }

    public ArrayList<StageItem> getAvailableStageItems() {
        return availableStageItems;
    }

    public void setAvailableStageItems(ArrayList<StageItem> availableStageItems) {
        this.availableStageItems = availableStageItems;
    }

    public void setStageItemOptions(ArrayList<StageItem> stageItemOptions) {
        this.stageItemOptions = stageItemOptions;
    }

    public ArrayList<StageItem> getStageItemSummary() {
        return stageItemSummary;
    }

    public void setStageItemSummary(ArrayList<StageItem> stageItemSummary) {
        this.stageItemSummary = stageItemSummary;
    }


}

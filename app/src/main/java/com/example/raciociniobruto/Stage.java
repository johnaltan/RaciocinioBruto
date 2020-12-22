package com.example.raciociniobruto;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public abstract class Stage {
    private String stageName;
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

    public void setStageName(String stageName){
        this.stageName = stageName;
    }

    public String getStageName(){
        return this.stageName;
    }

    public String askInfo(String info){
        StageItem item = null;
        for (StageItem i : availableStageItems) {     //search for items in clinical case
            if (i.getName().equalsIgnoreCase(info)) {
                item = i;
                break;
            }
        }
        if (item == null){
            for (StageItem i : stageItemOptions) {  //search for items in whole options
                if (i.getName().equalsIgnoreCase(info)) {
                    item = i;
                    break;
                }
            }
        }
        if (item == null) {  //if neither clinical case or whole options, it doesn't exist
            askedStageItems.add(new StageItem(info,null));
            return null;
        }
        askedStageItems.add(item);
        return item.getValue();
    }

    public ArrayList<String> nameInfoOptions() {
        return informStageItemsNames(stageItemOptions);
    }

    public ArrayList<String> nameAskedInfos(){
        return informStageItemsNames(askedStageItems);

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

    public ArrayList<StageItem> getAskedItems (){
        return this.askedStageItems;
    }

    public void setStageItemSummary(ArrayList<StageItem> stageItemSummary) {
        this.stageItemSummary = stageItemSummary;
    }

    private ArrayList<String> informStageItemsNames (ArrayList<StageItem> e){
        ArrayList<String> infoOptions = new ArrayList<String>();
        for (StageItem i : e) infoOptions.add(i.getName());
        return infoOptions;
    }

    public ArrayList<StageItem> getStageItemOptions() {
        return stageItemOptions;
    }

    public ArrayList<StageItem> getAskedStageItems() {
        return askedStageItems;
    }

    public void setAskedStageItems(ArrayList<StageItem> askedStageItems) {
        this.askedStageItems = askedStageItems;
    }
}

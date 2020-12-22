package com.example.raciociniobruto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public abstract class Stage {
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

    public JSONArray generateJSONArrayObject(ArrayList<StageItem> items) throws JSONException {
        JSONArray arrayObject = new JSONArray();
        for(int i = 0; i < items.size();i++)
            arrayObject.put(i,items.get(i).toJSONObject());
        return arrayObject;
    }

    public ArrayList<StageItem> JSONArraytoArrayList (JSONArray jsonArray) throws JSONException {
        ArrayList<StageItem> arrayList = new ArrayList<StageItem>();
        for(int i = 0; i < jsonArray.length(); i++)
            arrayList.add((StageItem)jsonArray.get(i));
        return arrayList;
    }


}

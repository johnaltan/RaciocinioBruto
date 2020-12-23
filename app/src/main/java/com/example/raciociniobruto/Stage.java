package com.example.raciociniobruto;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<StageItem> availableItems;
    private ArrayList<StageItem> itemsOptions;
    private ArrayList<String> itemsSummaryNames;
    private ArrayList<String> askedItemsNames;

    public Stage() {
        this.availableItems = new ArrayList<StageItem>();
        this.itemsOptions = new ArrayList<StageItem>();
        this.itemsSummaryNames = new ArrayList<String>();
        this.askedItemsNames = new ArrayList<String>();

    }

    public Stage (String name){
        this.name = name;
        this.availableItems = new ArrayList<StageItem>();
        this.itemsOptions = new ArrayList<StageItem>();
        this.itemsSummaryNames = new ArrayList<String>();
        this.askedItemsNames = new ArrayList<String>();

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String findItem(String itemName, boolean ask){
        StageItem item = null;
        for (StageItem i : availableItems) {     //search for items in clinical case
            if (i.getName().equalsIgnoreCase(itemName)) {
                item = i;
                break;
            }
        }
        if (item == null){
            for (StageItem i : itemsOptions) {  //search for items in whole options
                if (i.getName().equalsIgnoreCase(itemName)) {
                    item = i;
                    break;
                }
            }
        }
        if (item == null) {  //if neither clinical case or whole options, it doesn't exist
            if(ask) askedItemsNames.add(itemName);
            return null;
        }
        if (ask) askedItemsNames.add(item.getName());
        return item.getValue();
    }


    public ArrayList<String> nameItemsOptions() {
        ArrayList<String> infoOptions = new ArrayList<String>();
        for (StageItem i : itemsOptions) infoOptions.add(i.getName());
        return infoOptions;
    }

    public ArrayList<String> nameAskedItems(){
        return this.askedItemsNames;
    }

    public ArrayList<String> getSummaryItemsNames (){
        return this.itemsSummaryNames;
    }

    public void addAvailableItem(StageItem newItem){
        this.availableItems.add(newItem);
    }

    public void addItemSummaryName (String newItem){
        this.itemsSummaryNames.add(newItem);
    }

    public ArrayList<StageItem> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ArrayList<StageItem> availableItems) {
        this.availableItems = availableItems;
    }

    public void setItemsOptions(ArrayList<StageItem> itemsOptions) {
        this.itemsOptions = itemsOptions;
    }

    public ArrayList<StageItem> getItemsOptions() {
        return itemsOptions;
    }

}

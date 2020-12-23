package com.example.raciociniobruto;

import java.util.ArrayList;

public class StageBean {
    private ArrayList<StageItem> availableItems;
    private ArrayList<String> itemsSummaryNames;

    public StageBean() {
        this.availableItems = new ArrayList<StageItem>();
        this.itemsSummaryNames = new ArrayList<String>();
    }

    public StageBean(ArrayList<StageItem> availableItems, ArrayList<String> itemsSummaryNames) {
        this.availableItems = availableItems;
        this.itemsSummaryNames = itemsSummaryNames;
    }

    public ArrayList<StageItem> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ArrayList<StageItem> availableItems) {
        this.availableItems = availableItems;
    }

    public ArrayList<String> getItemsSummaryNames() {
        return itemsSummaryNames;
    }

    public void setItemsSummaryNames(ArrayList<String> itemsSummaryNames) {
        this.itemsSummaryNames = itemsSummaryNames;
    }

    public void addAvailableItem(StageItem newItem){
        this.availableItems.add(newItem);
    }

    public void addItemSummaryName (String newItem){
        this.itemsSummaryNames.add(newItem);
    }
}

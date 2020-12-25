package com.example.raciociniobruto;

import java.util.ArrayList;

public class StageBean {
    private ArrayList<StageItem> availableItems;
    private String summary;

    public StageBean() {
        this.availableItems = new ArrayList<StageItem>();
    }

    public StageBean(ArrayList<StageItem> availableItems) {
        this.availableItems = availableItems;
    }

    public ArrayList<StageItem> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ArrayList<StageItem> availableItems) {
        this.availableItems = availableItems;
    }
    public void addAvailableItem(StageItem newItem){
        this.availableItems.add(newItem);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

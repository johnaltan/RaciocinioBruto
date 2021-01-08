package com.example.raciociniobruto;

import java.util.List;
import java.util.ArrayList;

public class StageBean {
    private List<StageItem> availableItems;
    private String summary;

    public StageBean() {
        this.availableItems = new ArrayList<StageItem>();
    }

    public StageBean(List<StageItem> availableItems) {
        this.availableItems = availableItems;
    }

    public List<StageItem> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<StageItem> availableItems) {
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

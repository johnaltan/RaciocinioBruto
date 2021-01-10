package com.example.raciociniobruto;

import java.util.List;
import java.util.ArrayList;

public class StageBean {
    private List<StageItemBean> availableItems;
    private String summary;

    public StageBean() {
        this.availableItems = new ArrayList<StageItemBean>();
    }

    public StageBean(List<StageItemBean> availableItems) {
        this.availableItems = availableItems;
    }

    public List<StageItemBean> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<StageItemBean> availableItems) {
        this.availableItems = availableItems;
    }
    public void addAvailableItem(StageItemBean newItem){
        this.availableItems.add(newItem);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

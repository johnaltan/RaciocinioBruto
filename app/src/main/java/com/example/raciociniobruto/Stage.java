package com.example.raciociniobruto;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<Integer> askedFoundItemsIndexes;
    private ArrayList<String> notFoundItemsNames;
    private StageBean stageBean;

    public Stage() {
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
        stageBean = new StageBean();
    }

    public Stage (String name, StageBean stageBean){
        this.name = name;
        this.stageBean = stageBean;
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
    }

    public Stage (String name){
        this.name = name;
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
        stageBean = new StageBean();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String askItem(String itemName){
        String itemValue = null;
        for (int x = 0;x < stageBean.getAvailableItems().size(); x++) {
            StageItem i = stageBean.getAvailableItems().get(x);
            if (i.getName().equalsIgnoreCase(itemName) || i.isSynonym(itemName)) {
                itemValue = i.getValue();
                askedFoundItemsIndexes.add(x); //save index founded
                break;
            }
        }
        if (itemValue == null) notFoundItemsNames.add(itemName);
        return itemValue;
    }

    public String findAskedItemValue (String itemName){
        String itemValue = null;
        for (Integer i : askedFoundItemsIndexes){
            StageItem item = stageBean.getAvailableItems().get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemValue = item.getValue();
                break;
            }
        }
        return itemValue;
    }

    public ArrayList<String> nameAskedFoundItems(){
        ArrayList<String> namesAskedItems = new ArrayList<String>();
        for (Integer i : askedFoundItemsIndexes) namesAskedItems.add(stageBean.getAvailableItems().get(i).getName());
        return namesAskedItems;
    }

    public ArrayList<String> nameNotFoundItems(){
        return this.notFoundItemsNames;
    }

    public String findSummaryItemValue (String itemName){
        String itemValue = null;
        boolean found = false;
        for (int i = 0; i < stageBean.getAvailableItems().size() && !found; i++) {
            for (String summaryName : stageBean.getItemsSummaryNames()) {
                StageItem item = stageBean.getAvailableItems().get(i);
                if (summaryName.equalsIgnoreCase(item.getName()) && itemName.equalsIgnoreCase(item.getName())) { //is summary item AND the searched?
                    itemValue = item.getValue();
                    found = true;
                    break;
                }
            }
        }
        return itemValue;
    }

    public ArrayList<String> getItemsSummaryNames(){
        return this.stageBean.getItemsSummaryNames();
    }

    public void addAvailableItem(StageItem newItem){
        this.stageBean.getAvailableItems().add(newItem);
    }

    public void addItemSummaryName (String newItem){
        this.stageBean.getItemsSummaryNames().add(newItem);
    }
}

package com.example.raciociniobruto;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<StageItem> availableItems;
    private ArrayList<String> itemsSummaryNames;
    private ArrayList<Integer> askedFoundItemsIndexes;
    private ArrayList<String> notFoundItemsNames;

    public Stage() {
        this.availableItems = new ArrayList<StageItem>();
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
        this.itemsSummaryNames = new ArrayList<String>();

    }

    public Stage (String name){
        this.name = name;
        this.availableItems = new ArrayList<StageItem>();
        this.itemsSummaryNames = new ArrayList<String>();
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String askItem(String itemName){
        String itemValue = null;
        for (int x = 0;x < availableItems.size(); x++) {
            StageItem i = availableItems.get(x);
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
            StageItem item = availableItems.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemValue = item.getValue();
                break;
            }
        }
        return itemValue;
    }

    public ArrayList<String> nameAskedFoundItems(){
        ArrayList<String> namesAskedItems = new ArrayList<String>();
        for (Integer i : askedFoundItemsIndexes) namesAskedItems.add(availableItems.get(i).getName());
        return namesAskedItems;
    }

    public ArrayList<String> nameNotFoundItems(){
        return this.notFoundItemsNames;
    }

    public String findSummaryItemValue (String itemName){
        String itemValue = null;
        boolean found = false;
        for (int i = 0; i < availableItems.size() && !found; i++) {
            for (String summaryName : itemsSummaryNames) {
                StageItem item = availableItems.get(i);
                if (summaryName.equalsIgnoreCase(item.getName()) && itemName.equalsIgnoreCase(item.getName())) { //is summary item AND the searched?
                    itemValue = item.getValue();
                    found = true;
                    break;
                }
            }
        }
        return itemValue;
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
}

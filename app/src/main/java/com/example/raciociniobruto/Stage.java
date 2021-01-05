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

    public StageItem askItem(String itemName){
        StageItem item = null;
        itemName = StringTreater.adjustSpelling(itemName);
        for (int x = 0;x < stageBean.getAvailableItems().size(); x++) {
            StageItem i = stageBean.getAvailableItems().get(x);
            if (StringTreater.adjustSpelling(i.getName()).equalsIgnoreCase(itemName) || i.isSynonym(itemName)) {
                item = stageBean.getAvailableItems().get(x);
                askedFoundItemsIndexes.add(x); //save index founded
                break;
            }
        }
        if (item == null) notFoundItemsNames.add(itemName);
        return item;
    }

    public String findAskedItemValue (String itemName){
        String itemValue = null;
        itemName = StringTreater.adjustSpelling(itemName);
        for (Integer i : askedFoundItemsIndexes){
            StageItem item = stageBean.getAvailableItems().get(i);
            if (StringTreater.adjustSpelling(item.getName()).equalsIgnoreCase(itemName)) {
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

    public ArrayList<StageItem> getAskedFoundItems(){
        ArrayList<StageItem> stageItems = new ArrayList<StageItem>();
        for(Integer i : askedFoundItemsIndexes) stageItems.add(stageBean.getAvailableItems().get(i));
        return stageItems;
    }

    public ArrayList<String> nameNotFoundItems(){
        return this.notFoundItemsNames;
    }

    public ArrayList<StageItem> getNotFoundItems(){
        ArrayList<StageItem> stageItems = new ArrayList<StageItem>();
        for(String i : this.notFoundItemsNames) stageItems.add(new StageItem(i,null));
        return stageItems;
    }

    public ArrayList<String> getNotFoundItemsNames() {
        return notFoundItemsNames;
    }

    public void setNotFoundItemsNames(ArrayList<String> notFoundItemsNames) {
        this.notFoundItemsNames = notFoundItemsNames;
    }

    public void addAvailableItem(StageItem newItem){
        this.stageBean.getAvailableItems().add(newItem);
    }

    public String getSummary(){
        return this.stageBean.getSummary();
    }

    public int informAvailableItemsAmount(){
        return this.stageBean.getAvailableItems().size();
    }


}

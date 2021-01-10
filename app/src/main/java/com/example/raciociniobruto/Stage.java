package com.example.raciociniobruto;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<Integer> askedFoundItemsIndexes;
    private ArrayList<Integer> tempAskedFoundItemsIndexes;
    private ArrayList<String> notFoundItemsNames;
    private ArrayList<StageItem> availableItems;

    private StageBean stageBean;

    public Stage() {
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.tempAskedFoundItemsIndexes = new ArrayList<Integer>();
        this.notFoundItemsNames = new ArrayList<String>();
        this.availableItems = new ArrayList<StageItem>();
        stageBean = new StageBean();
    }

    public Stage (String name, StageBean stageBean){
        this.name = name;
        this.stageBean = stageBean;
        this.availableItems = new ArrayList<StageItem>();
        for(int i = 0; i < stageBean.getAvailableItems().size(); i++) availableItems.add(new StageItem(stageBean.getAvailableItems().get(i)));
        this.askedFoundItemsIndexes = new ArrayList<Integer>();
        this.tempAskedFoundItemsIndexes = new ArrayList<Integer>();
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

    public ArrayList<StageItem> askItem(String inquiryName) throws AlmostMinimumNecessaryException{
        this.tempAskedFoundItemsIndexes.clear();
        ArrayList<StageItem> items = new ArrayList<StageItem>();

        for (int x = 0;x < this.availableItems.size(); x++) {
            StageItem i = this.availableItems.get(x);
            if (i.existFromInquiryName(inquiryName)) {
                items.add(this.availableItems.get(x));
                this.tempAskedFoundItemsIndexes.add(x);
            }
        }
        if(this.tempAskedFoundItemsIndexes.size() == 1) this.saveTempFoundItemsIndexes(null);
        if (items.size() == 0) notFoundItemsNames.add(inquiryName);
        return items;
    }

    public void saveTempFoundItemsIndexes(ArrayList<Integer> indexesToSave){ //these indexes are of temporary list, not of available list

        if (indexesToSave == null) {
            for(int i : this.tempAskedFoundItemsIndexes) this.askedFoundItemsIndexes.add(i); //if indexesToSave == null save all
        }else {
            for (int c : indexesToSave)
                this.askedFoundItemsIndexes.add(tempAskedFoundItemsIndexes.get(c));
        }
        this.tempAskedFoundItemsIndexes.clear();
    }

    public String findAskedItemValue (String itemName){
        String itemValue = null;
        for (Integer i : askedFoundItemsIndexes){
            StageItem item = this.availableItems.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemValue = item.getValue();
                break;
            }
        }
        return itemValue;
    }

    public ArrayList<String> nameAskedFoundItems(){
        ArrayList<String> namesAskedItems = new ArrayList<String>();
        for (Integer i : askedFoundItemsIndexes) namesAskedItems.add(this.availableItems.get(i).getName());
        return namesAskedItems;
    }

    public ArrayList<StageItem> getAskedFoundItems(){
        ArrayList<StageItem> stageItems = new ArrayList<StageItem>();
        for(Integer i : askedFoundItemsIndexes) stageItems.add(this.availableItems.get(i));
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
        this.availableItems.add(newItem);
    }

    public String getSummary(){
        return this.stageBean.getSummary();
    }

    public int informAvailableItemsAmount(){
        return this.availableItems.size();
    }


}

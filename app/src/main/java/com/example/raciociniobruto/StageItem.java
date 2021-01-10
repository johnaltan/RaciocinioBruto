package com.example.raciociniobruto;

import java.util.List;
import android.util.Log;

public class StageItem {

    StageItemBean stageItemBean;

    public StageItem() {
    }

    public StageItem(String name, String value){
        stageItemBean = new StageItemBean(name,value);
    }

    public StageItem(StageItemBean stageItemBean) {
        this.stageItemBean = stageItemBean;
        prepareSynonymsToCompare();
    }

    public void setStageItemBean(StageItemBean stageItemBean){
        this.stageItemBean = stageItemBean;
        prepareSynonymsToCompare();
    }

    public String getName() {
        return stageItemBean.getName();
    }

    public void setName(String name) {
        stageItemBean.setName(name);
    }

    public String getValue() {
        return stageItemBean.getValue();
    }

    public void setValue(String value) {
        stageItemBean.setValue(value);
    }

    public List<String> getSynonyms() {
        return stageItemBean.getSynonyms();
    }

    public void setSynonyms(List<String> synonyms) {
        stageItemBean.setSynonyms(synonyms);
        prepareSynonymsToCompare();
    }

    private void prepareSynonymsToCompare(){ //it must be done on object's construction
        if(stageItemBean.getSynonyms() != null) {
            for (int i = 0; i < this.stageItemBean.getSynonyms().size(); i++) {
                stageItemBean.getSynonyms().set(i, StringTreater.adjustSpelling(stageItemBean.getSynonyms().get(i)).trim());
            }
            if (stageItemBean.getNonMedicalAdjectives() != null) {
                for (String s : this.stageItemBean.getNonMedicalAdjectives()) {
                    for (int i = 0; i < this.stageItemBean.getSynonyms().size(); i++) {
                        stageItemBean.getSynonyms().set(i, stageItemBean.getSynonyms().get(i).replaceAll(" " + StringTreater.adjustSpelling(s), ""));
                    }
                }
            }
        }
    }

    public boolean existFromInquiryName(String inquiryName) throws AlmostMinimumNecessaryException{
        String adjustedInquiryName = StringTreater.adjustSpelling(inquiryName);
        String adjustedItemName = StringTreater.adjustSpelling(this.stageItemBean.getName());

        //remove nonMedicalAdjectives
        if(stageItemBean.getNonMedicalAdjectives() != null) {
            for(String s : this.stageItemBean.getNonMedicalAdjectives()) {
                adjustedInquiryName = adjustedInquiryName.replaceAll(" " + StringTreater.adjustSpelling(s),"");
                adjustedItemName = adjustedItemName.replaceAll(" " + StringTreater.adjustSpelling(s),"");
            }
        }

        adjustedInquiryName = adjustedInquiryName.trim();
        adjustedItemName = adjustedItemName.trim();

        //if item name matches with inquiry name
        if(adjustedItemName.equalsIgnoreCase(adjustedInquiryName)) return true;

        //if a synonym matches with inquiry name
        if (this.stageItemBean.getSynonyms() != null)
            for(String s : this.stageItemBean.getSynonyms()) if (s.equalsIgnoreCase(adjustedInquiryName)) return true;

        //if at least 2 words on inquiry name matches with item name
        if(StringTreater.containsMinimumNecessary(adjustedInquiryName,adjustedItemName)) return true;

        //if at least 2 words on inquiry name matches with an synonym
        if (this.stageItemBean.getSynonyms() != null)
            for(String s : this.stageItemBean.getSynonyms()) if (StringTreater.containsMinimumNecessary(adjustedInquiryName,s)) return true;

        //if there are almost minimum to find an item on inquiry name to match with item name
        if(StringTreater.containsAlmostMinimumNecessary(adjustedInquiryName,adjustedItemName)) throw new AlmostMinimumNecessaryException();

        //if there are almost minimum to find an item on inquiry name to match with an synonym
        if (this.stageItemBean.getSynonyms() != null)
            for(String s : this.stageItemBean.getSynonyms())
                if (StringTreater.containsAlmostMinimumNecessary(adjustedInquiryName,s)) throw new AlmostMinimumNecessaryException();

        return false;
    }


    public void setValueIsImage(boolean valueIsImage){
        stageItemBean.setValueIsImage(valueIsImage);
    }

    public boolean getValueIsImage() {
        return stageItemBean.getValueIsImage();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != this.getClass()) return false;

        final StageItem other = (StageItem) obj;
        if ((this.getName() == null) ? (other.getName() != null) : !this.getName().equals(other.getName()))
            return false;

        if (this.getValue() != other.getValue()) return false;
        return true;
    }
}

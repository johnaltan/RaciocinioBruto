package com.example.raciociniobruto;

import java.util.List;
import android.util.Log;

public class StageItem {
    private String name;
    private String value;
    private List<String> synonyms;
    private List<String> nonMedicalAdjectives;
    private boolean valueIsImage;

    public StageItem() {


    }

    public StageItem(String name, String value) {
        this.name = name;
        this.value = value;
        this.synonyms = null;
    }

    public StageItem(String name, String value, List<String> synonyms) {
        this.name = name;
        this.value = value;
        this.synonyms = synonyms;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public boolean existFromInquiryName(String inquiryName) throws AlmostMinimumNecessaryException{
        String adjustedInquiryName = StringTreater.adjustSpelling(inquiryName);
        String adjustedItemName = StringTreater.adjustSpelling(this.name);

        //remove nonMedicalAdjectives from inquiryName
        if(nonMedicalAdjectives != null) for(String s : this.nonMedicalAdjectives) adjustedInquiryName = adjustedInquiryName.replaceAll(" " + StringTreater.adjustSpelling(s),"");

        adjustedInquiryName = adjustedInquiryName.trim();
        adjustedItemName = adjustedItemName.trim();

        //if item name matches with inquiry name
        if(adjustedItemName.equalsIgnoreCase(adjustedInquiryName)) return true;

        //if a synonym matches with inquiry name
        if (this.synonyms != null)
            for(String s : this.synonyms) if (StringTreater.adjustSpelling(s).equalsIgnoreCase(adjustedInquiryName)) return true;

        //if at least 2 words on inquiry name matches with item name
        if(StringTreater.containsMinimumNecessary(adjustedInquiryName,adjustedItemName)) return true;

        //if at least 2 words on inquiry name matches with an synonym
        if (this.synonyms != null)
            for(String s : this.synonyms) if (StringTreater.containsMinimumNecessary(adjustedInquiryName,StringTreater.adjustSpelling(s))) return true;

        //if there are almost minimum to find an item on inquiry name to match with item name
        if(StringTreater.containsAlmostMinimumNecessary(adjustedInquiryName,adjustedItemName)) throw new AlmostMinimumNecessaryException();

        //if there are almost minimum to find an item on inquiry name to match with an synonym
        if (this.synonyms != null)
            for(String s : this.synonyms)
                if (StringTreater.containsAlmostMinimumNecessary(adjustedInquiryName,StringTreater.adjustSpelling(s))) throw new AlmostMinimumNecessaryException();

        return false;
    }


    public void setValueIsImage(boolean valueIsImage){
        this.valueIsImage = valueIsImage;
    }

    public boolean getValueIsImage(){
        return this.valueIsImage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != this.getClass()) return false;

        final StageItem other = (StageItem) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
            return false;

        if (this.value != other.value) return false;
        return true;
    }
}

package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StageItem {
    private String name;
    private String value;
    private String [] synonyms;
    private boolean valueIsImage;

    public StageItem() {


    }

    public StageItem(String name, String value) {
        this.name = name;
        this.value = value;
        this.synonyms = null;
    }

    public StageItem(String name, String value, String [] synonyms) {
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

    public boolean isSynonym (String possibleSynonym){
        if (synonyms != null)
            for(String s : synonyms) if (StringTreater.adjustSpelling(s).equalsIgnoreCase(possibleSynonym)) return true;
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

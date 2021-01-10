package com.example.raciociniobruto;

import java.util.List;

public class StageItemBean {
    private String name;
    private String value;
    private List<String> synonyms;
    private List<String> nonMedicalAdjectives;
    private boolean valueIsImage;

    public StageItemBean(String name, String value) {
        this.name = name;
        this.value = value;
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

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getNonMedicalAdjectives() {
        return nonMedicalAdjectives;
    }

    public void setNonMedicalAdjectives(List<String> nonMedicalAdjectives) {
        this.nonMedicalAdjectives = nonMedicalAdjectives;
    }

    public boolean getValueIsImage() {
        return valueIsImage;
    }

    public void setValueIsImage(boolean valueIsImage) {
        this.valueIsImage = valueIsImage;
    }

}

package com.example.raciociniobruto;

public class Disease {
    private String name;
    private String [] synonyms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public boolean isCorrectDiagnosis(String inquiryHypothesis){
        String adjustedInquiryHypothesis = StringTreater.adjustSpelling(inquiryHypothesis);
        String adjustedDiseaseName = StringTreater.adjustSpelling(this.name);

        if(adjustedDiseaseName.equalsIgnoreCase(adjustedInquiryHypothesis)) return true; //if item name matches with inquiry diagnosis

        if (this.synonyms != null)
            for(String s : this.synonyms) if (StringTreater.adjustSpelling(s).equalsIgnoreCase(adjustedInquiryHypothesis)) return true; //if a synonym matches with inquiry diagnosis
        return false;
    }
}

package com.example.raciociniobruto;

public class ClinicalCase {
    private Disease[] diseases;


    private StageBean anamnesis;
    private StageBean physicalExam;
    private StageBean complementaryExam;

    public ClinicalCase() {
    }

    public ClinicalCase(StageBean anamnesis, Disease[] diseases, StageBean physicalExam, StageBean complementaryExam) {
        this.anamnesis = anamnesis;
        this.diseases = diseases;
        this.physicalExam = physicalExam;
        this.complementaryExam = complementaryExam;
    }

    public StageBean getAnamnesis() {
        return anamnesis;
    }

    public Disease[] getDiseases() {
        return diseases;
    }

    public StageBean getPhysicalExam() {
        return physicalExam;
    }

    public StageBean getComplementaryExam() {
        return complementaryExam;
    }
}

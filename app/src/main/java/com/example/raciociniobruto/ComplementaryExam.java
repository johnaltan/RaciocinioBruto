package com.example.raciociniobruto;

public class ComplementaryExam extends Stage{

    public ComplementaryExam() {
        super.setName("Exames complementares");
        StageItem standard = new StageItem("Algum?", "Deseja algum exame?");
        super.addStageItemSummary(standard);
        super.addAvailableStageItem(standard);
        super.addAvailableStageItem(new StageItem("LCR", "Pressão de abertura alta"));
    }
}

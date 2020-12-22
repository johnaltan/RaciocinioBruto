package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

public class ComplementaryExam extends Stage {

    public ComplementaryExam() {
        super.setStageName("Exames complementares");
        StageItem standard = new StageItem("Algum?", "Deseja algum exame?");
        super.addStageItemSummary(standard);
        super.addAvailableStageItem(standard);
        super.addAvailableStageItem(new StageItem("LCR", "Pressão de abertura alta"));
    }
}

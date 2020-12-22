package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

public class ComplementaryExam extends Stage implements Transferable{

    public ComplementaryExam() {
        super.setName("Exames complementares");
        StageItem standard = new StageItem("Algum?", "Deseja algum exame?");
        super.addStageItemSummary(standard);
        super.addAvailableStageItem(standard);
        super.addAvailableStageItem(new StageItem("LCR", "Pressão de abertura alta"));
    }

    @Override
    public JSONObject toJSONObject() throws JSONException {
        return null;
    }

    @Override
    public Transferable fromJSONObject(JSONObject jsonObject) throws JSONException {
        return null;
    }
}

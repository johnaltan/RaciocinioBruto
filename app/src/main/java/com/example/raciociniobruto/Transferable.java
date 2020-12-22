package com.example.raciociniobruto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public interface Transferable {

    public JSONObject toJSONObject () throws JSONException;
    public Transferable fromJSONObject (JSONObject jsonObject) throws JSONException;


}

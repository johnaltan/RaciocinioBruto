package com.example.raciociniobruto;

import java.util.HashMap;

public class Reporter {
    private String date;
    private String contentCSV;

    public Reporter(){

    }

    public static HashMap<String,String> reportNotFoundItems (Scene scene){
        HashMap<String,String> output = new HashMap<String,String>();

        for(Stage s : scene.getStages()){
            String itemsNames = new String();
            for (String i : s.nameNotFoundItems()) itemsNames += i + ",";
            if(itemsNames.contains(",")) itemsNames = itemsNames.substring(0,itemsNames.lastIndexOf(","));
            output.put(s.getName(),itemsNames);
        }
        return output;
    }



}

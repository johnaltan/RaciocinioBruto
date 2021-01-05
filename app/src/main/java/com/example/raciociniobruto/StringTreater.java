package com.example.raciociniobruto;

import java.text.Normalizer;

public class StringTreater {


    public static String adjustSpelling(String str){
        String adjusted;
        adjusted = Normalizer.normalize(str,Normalizer.Form.NFD);
        adjusted = adjusted.replaceAll("[^\\p{ASCII}]","");
        return adjusted;
    }

}

package com.example.raciociniobruto;

import java.text.Normalizer;

public class StringTreater {
    private static final String[] PREPOSITIONS = {"da","do","de"};


    public static String adjustSpelling(String str){
        String adjusted;
        adjusted = Normalizer.normalize(str,Normalizer.Form.NFD);
        adjusted = adjusted.replaceAll("[^\\p{ASCII}]","");

        adjusted = adjusted.toLowerCase();

        for(String i : PREPOSITIONS) adjusted = adjusted.replaceAll(" "+i+" "," ");

        return adjusted;
    }

    public static int countWords (String str){

        if (str == null) return 0;
        str = str.trim();
        if(str.equals(""))return 0;

        //split the string by one or more space
        String[] temp = str.split("\\s+");

        //number of array elements is equal to the words
        return temp.length;
    }

    public static boolean containsMinimumNecessary(String inquiry, String test) {
        int matches = 0;

        if ((StringTreater.countWords(inquiry) >= 2) && ((StringTreater.countWords(inquiry) == (StringTreater.countWords(test) - 1))))
            for (String s : inquiry.split("\\s+")) if (test.contains(s)) matches++;

        return matches >= 2;
    }
}

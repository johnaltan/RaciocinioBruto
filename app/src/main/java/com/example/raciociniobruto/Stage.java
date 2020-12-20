package com.example.raciociniobruto;

import java.util.HashMap;
import java.util.Set;

public class Stage {
    protected HashMap<String,String> info;

    public Stage() {
        this.info = new HashMap<String,String>();
    }

    public Stage(HashMap<String, String> info) {
        this.info = info;
    }

    String getInfo(String info){
        return this.info.get(info);
    }

    Set<String> getKeys() {
        return this.info.keySet();
    }
}

package com.example.raciociniobruto;

import org.json.JSONException;
import org.json.JSONObject;

public class StageItem {
    private String name;
    private String value;

    public StageItem() {
    }

    public StageItem(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != this.getClass()) return false;

        final StageItem other = (StageItem) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
            return false;

        if (this.value != other.value) return false;
        return true;
    }
}

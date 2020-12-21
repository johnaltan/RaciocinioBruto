package com.example.raciociniobruto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> title = new MutableLiveData<String>();
    private final MutableLiveData<ArrayList<String>> infoOptions = new MutableLiveData<ArrayList<String>>();
    private final MutableLiveData<ArrayList<String>> infoAdded = new MutableLiveData<ArrayList<String>>();


    public void setInfoOptions(ArrayList<String> item) {
        infoOptions.setValue(item);
    }

    public void setInfoAdded(ArrayList<String> item) {
        infoAdded.setValue(item);
    }

    public void setTitle (String item){
        title.setValue(item);
    }


    public LiveData<ArrayList<String>> getInfoOptions() {
        return infoOptions;
    }

    public LiveData<ArrayList<String>> getInfoAdded() {
        return infoAdded;
    }

    public LiveData<String> getTitle(){
        return title;
    }

}

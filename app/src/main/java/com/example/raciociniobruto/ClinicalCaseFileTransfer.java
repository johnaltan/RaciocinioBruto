package com.example.raciociniobruto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClinicalCaseFileTransfer implements ClinicalCaseTransfer {
    private Context context;
    private String fileName;


    public ClinicalCaseFileTransfer(String fileName, Context context){
        this.context = context;
        this.fileName = fileName;
    }
    @Override
    public ArrayList<ClinicalCase> loadCases() {
        FileInputStream fis = null;
        ArrayList<ClinicalCase> loadedClinicalCases = null;

        try {
            fis = new FileInputStream(new File(context.getExternalFilesDir(null),fileName));

            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String fileContent;
            while ((fileContent = br.readLine()) != null) {
                sb.append(fileContent).append("\n");
            }
            Gson gson = new Gson();
            loadedClinicalCases = gson.fromJson(sb.toString(), new TypeToken<ArrayList<ClinicalCase>>(){}.getType());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loadedClinicalCases;
    }

    @Override
    public void sendCases(ArrayList<ClinicalCase> clinicalCases) {


        FileOutputStream fos = null;
        try {
            Gson gson = new Gson();
            String gsonString = gson.toJson(clinicalCases);

            fos = new FileOutputStream(new File(context.getExternalFilesDir(null),fileName));
            fos.write(gsonString.getBytes());
            Log.d("GSON file written",gsonString);

            Log.d("FILESAVED","Saved to " + this.context.getExternalFilesDir(null) + "/" + this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

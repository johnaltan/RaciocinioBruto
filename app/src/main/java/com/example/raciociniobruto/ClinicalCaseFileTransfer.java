package com.example.raciociniobruto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    Context context;


    public ClinicalCaseFileTransfer(Context context){
        this.context = context;
    }
    @Override
    public ArrayList<ClinicalCase> loadCases(Uri uri) {
        FileInputStream fis = null;
        ArrayList<ClinicalCase> loadedClinicalCases = null;

        try {
            fis = (FileInputStream) context.getContentResolver().openInputStream(uri);

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
    public void sendCases(ArrayList<ClinicalCase> clinicalCases, Uri uri) {


        FileOutputStream fos = null;
        try {
            Gson gson = new Gson();
            String gsonString = gson.toJson(clinicalCases);

            fos = (FileOutputStream) context.getContentResolver().openOutputStream(uri);
            fos.write(gsonString.getBytes());
            Log.d("GSON file written",gsonString);

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

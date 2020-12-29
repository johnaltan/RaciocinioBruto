package com.example.raciociniobruto;

import android.net.Uri;
import android.util.Log;

import java.net.URLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class ClinicalCaseWebTransfer implements ClinicalCaseTransfer {

    public ClinicalCaseWebTransfer() {
    }

    @Override
    public ArrayList<ClinicalCase> loadCases (Uri uri){
        String str="https://drive.google.com/uc?export=download&id=15Uv_hpsOafUHkDTHiMLzCxdUMZub9bad";
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        ArrayList<ClinicalCase> loadedClinicalCases = null;
        try
        {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
            Gson gson = new Gson();
            Log.d("Download",stringBuffer.toString());
            loadedClinicalCases = gson.fromJson(stringBuffer.toString(), new TypeToken<ArrayList<ClinicalCase>>(){}.getType());

        }
        catch(Exception ex)
        {
            Log.e("App", "yourDataTask", ex);
            return null;
        }
        finally
        {
            if(bufferedReader != null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loadedClinicalCases;
    }

    @Override
    public void sendCases (ArrayList<ClinicalCase> clinicalCases, Uri uri){

    }
}

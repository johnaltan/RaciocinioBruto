package com.example.raciociniobruto;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
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
        ArrayList<ClinicalCase> loadedClinicalCases = new ArrayList<ClinicalCase>();

        try {
            fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String fileContent;
            while ((fileContent = br.readLine()) != null) {
                sb.append(fileContent).append("\n");
            }
            JSONArray jsonArray = new JSONArray(fileContent);
            for (int i = 0; i < jsonArray.length(); i++) {
                ClinicalCase clinicalCase = (ClinicalCase)jsonArray.get(i);
                loadedClinicalCases.add(clinicalCase);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
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
        return null;
    }

    @Override
    public void sendCases(ArrayList<ClinicalCase> clinicalCases) {


        FileOutputStream fos = null;
        try {
            JSONArray jsonArrayObject = new JSONArray();
            for(int i = 0; i < clinicalCases.size(); i++)
                jsonArrayObject.put(i,clinicalCases.get(i).toJSONObject());
            fos = this.context.openFileOutput(this.fileName, Context.MODE_PRIVATE);
            fos.write(jsonArrayObject.toString().getBytes());
            Log.d("JSON file",jsonArrayObject.toString(1));

           // Toast.makeText(this, "Saved to " + this.context.getFilesDir() + "/" + this.fileName,
           //         Toast.LENGTH_LONG).show();
            Log.d("FILESAVED","Saved to " + this.context.getFilesDir() + "/" + this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
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

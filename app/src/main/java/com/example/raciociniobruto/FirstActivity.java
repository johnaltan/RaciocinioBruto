package com.example.raciociniobruto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.app.ProgressDialog;

import android.os.AsyncTask;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstActivity extends AppCompatActivity {
    private static final int PICK_JSON_FILE = 2;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    public void buttonSearchCasesAction(View view) {
        openFile();
    }

    public void buttonDownloadCasesAction(View view) {
        downloadCases();
    }

    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/json");


        startActivityForResult(intent, PICK_JSON_FILE);
    }

    private void downloadCases() {
        new DownloaderTask().execute();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("ONACTIVITYRESULT", "Voltou");
        if (resultCode == Activity.RESULT_OK && requestCode == this.PICK_JSON_FILE) {
            Log.d("ONACTIVITYRESULT", "Respondeu: " + data.getData());
            ClinicalCaseFileTransfer transfer = new ClinicalCaseFileTransfer(this);
            ArrayList<ClinicalCase> clinicalCases = transfer.loadCases(data.getData());
            MainActivity.setScene(new Scene(clinicalCases.get(0)));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void postClinicalCaseFirebase(String clinicalCaseJSON) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("casosClinicos").
                add(clinicalCaseJSON)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }


    protected class DownloaderTask extends AsyncTask <Void, String, ArrayList<ClinicalCase>>{

        @Override
        protected ArrayList<ClinicalCase> doInBackground (Void... params){
            ClinicalCaseWebTransfer transfer = new ClinicalCaseWebTransfer();
            return transfer.loadCases(null);

        }

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            pd = new ProgressDialog(FirstActivity.this);
            pd.setMessage("Baixando casos, aguarde...");
            pd.setCancelable(false);
            pd.show();

        }

        @Override
        protected void onPostExecute(ArrayList<ClinicalCase> result){
            super.onPostExecute(result);

            if (pd.isShowing()){
                pd.dismiss();
            }
            if(result != null) {
                MainActivity.setScene(new Scene(result.get(0)));
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }

    }

}
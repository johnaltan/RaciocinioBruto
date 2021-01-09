package com.example.raciociniobruto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.app.ProgressDialog;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

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
        pd = new ProgressDialog(FirstActivity.this);
        pd.setMessage("Baixando casos, aguarde...");
        pd.setCancelable(false);
        pd.show();

        OnLoadClinicalCasesListener loadListener = new OnLoadClinicalCasesListener() {
            @Override
            public void onLoadedClinicalCases(ArrayList<ClinicalCase> clinicalCases) {
                if (pd.isShowing()) {
                    pd.dismiss();
                }
                CharSequence[] nameItems = new CharSequence[clinicalCases.size()];
                for (int c = 0; c < nameItems.length; c++) nameItems[c] = clinicalCases.get(c).getAnamnesis().getSummary();

                AlertDialog.Builder builder = new AlertDialog.Builder(FirstActivity.this);
                builder.setTitle("Selecione o caso:")
                        .setItems(nameItems, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item

                                MainActivity.setScene(new Scene(clinicalCases.get(which)));
                                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        //new ClinicalCaseWebTransfer().loadCases(null,loadListener);
        new ClinicalCaseFirestoreTransfer().loadCases(null,loadListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("ONACTIVITYRESULT", "Voltou");
        if (resultCode == Activity.RESULT_OK && requestCode == this.PICK_JSON_FILE) {
            Log.d("ONACTIVITYRESULT", "Respondeu: " + data.getData());
            new ClinicalCaseFileTransfer(this).loadCases(data.getData(),new OnLoadClinicalCasesListener(){
                @Override
                public void onLoadedClinicalCases(ArrayList<ClinicalCase> clinicalCases) {
                    MainActivity.setScene(new Scene(clinicalCases.get(0)));
                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
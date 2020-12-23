package com.example.raciociniobruto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    private static final int PICK_JSON_FILE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    public void buttonAction(View view){
        openFile();
    }

    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/json");



        startActivityForResult(intent, PICK_JSON_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("ONACTIVITYRESULT","Voltou");
        if (resultCode == Activity.RESULT_OK && requestCode == this.PICK_JSON_FILE) {
            Log.d("ONACTIVITYRESULT","Respondeu: " + data.getData());
            ClinicalCaseFileTransfer transfer = new ClinicalCaseFileTransfer(this);
            ArrayList<ClinicalCase> clinicalCases = transfer.loadCases(data.getData());
            MainActivity.setScene(new Scene(clinicalCases.get(0)));
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
package com.example.raciociniobruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DiagnosticActivity extends AppCompatActivity {

    TextView txtContent;
    TextView txtTitle;
    EditText editTextOption;
    String stringTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);

        stringTxtContent = new String();

        txtContent = (TextView) findViewById(R.id.txt_content);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        editTextOption = (EditText) findViewById(R.id.editTextOption);


        ArrayList<String> triedHypothesis = MainActivity.nameTriedHypothesis();
        if (triedHypothesis.size() > 0) {
            stringTxtContent += "Hipóteses anteriores:\n";
            for (String s : triedHypothesis) stringTxtContent += s + "\n";
        }

        stringTxtContent += "\n\nRecém registradas:\n";
        txtContent.setText(stringTxtContent);

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = editTextOption.getText().toString();

                if(MainActivity.tryToDiagnose(i)){
                    Toast.makeText(v.getContext(),"PARABÉNS, VOCÊ ACERTOU O DIAGNÓSTICO: " + i, Toast.LENGTH_LONG).show();
                }

                stringTxtContent += i + "\n";
                txtContent.setText(stringTxtContent);

                editTextOption.setText("");
                editTextOption.requestFocus();
            }
        });

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showNotImplementedYetWarning(View view){
        Toast.makeText(view.getContext(),"Boa, fera. Mas isso ainda não foi implementado!", Toast.LENGTH_LONG).show();
    }
}
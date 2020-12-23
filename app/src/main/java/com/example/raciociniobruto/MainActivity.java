package com.example.raciociniobruto;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Scene scene;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null) {
            Stage anamnesis = new Stage("Anamnese");
            anamnesis.addAvailableItem(new StageItem("Nome", "JMC"));
            anamnesis.addAvailableItem(new StageItem("Idade", "56"));
            anamnesis.addAvailableItem(new StageItem("Sexo", "Masculino"));
            anamnesis.addAvailableItem(new StageItem("Profissão", "Pedreiro"));
            anamnesis.addAvailableItem(new StageItem("QP", "Dor de cabeça"));
            anamnesis.addAvailableItem(new StageItem("HDA", "Paciente vem ao consultório com queixa de dor de cabeça há 3 dias, de início súbito, unilateral. Refere piora da dor ao decúbito"));
            anamnesis.addAvailableItem(new StageItem("ISDAS", "SP"));
            anamnesis.addAvailableItem(new StageItem("HMP", "Nega comorbidades"));
            anamnesis.addAvailableItem(new StageItem("HMF", "Nega doenças na família"));
            anamnesis.addAvailableItem(new StageItem("HFS", "Nega tabagismo. Etilista crônico"));
            anamnesis.addItemSummaryName("Nome");
            anamnesis.addItemSummaryName("Idade");
            anamnesis.addItemSummaryName("Sexo");
            anamnesis.addItemSummaryName("HDA");

            ArrayList<ClinicalCase> clinicalCases = new ArrayList<ClinicalCase>();
            ClinicalCase clinicalCase = new ClinicalCase(anamnesis, null, new Stage("Exame Físico"), new Stage("Exames complementares"));
            this.scene = new Scene(clinicalCase);
            clinicalCases.add(clinicalCase);
            ClinicalCaseFileTransfer transfer = new ClinicalCaseFileTransfer("clinicalCases.json",this);
            transfer.sendCases(clinicalCases);

            /*ArrayList<ClinicalCase> readedCases = transfer.loadCases();

            String str = new String();
            for(ClinicalCase c : readedCases) str += c.getAnamnesis().getName();
            Log.d("LIDOS",str);*/
        }


    }


    public static int getStep() {
        return scene.getStep();
    }

    public static String findItem(String info, boolean ask) {
        return scene.findItem(info,ask);
    }

    public static ArrayList<String> nameInfoOptions() {
        return scene.nameItemOptions();
    }

    public static String getStageSummary() {
        return scene.getStageSummary();
    }

    public static String getStageName() {
        return scene.getStageName();
    }

    public static ArrayList<String> nameAskedItems () {
        return scene.nameAskedItems();
    }

    public static void setStagePos(int stagePos) {scene.setStagePos(stagePos);}
}
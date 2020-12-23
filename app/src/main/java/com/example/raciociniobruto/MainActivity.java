package com.example.raciociniobruto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Scene scene;

    private ArrayList<ClinicalCase> clinicalCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null) {

           // ClinicalCase clinicalCase = TESTgenerateClinicalCase();

           // clinicalCases = new ArrayList<ClinicalCase>();
           // clinicalCases.add(clinicalCase);

            //this.scene = new Scene(clinicalCase);

        }


    }





    private ClinicalCase TESTgenerateClinicalCase (){
        StageBean anamnesis = new StageBean();
        anamnesis.addAvailableItem(new StageItem("Nome", "JMC"));
        anamnesis.addAvailableItem(new StageItem("Idade", "56"));
        anamnesis.addAvailableItem(new StageItem("Sexo", "Masculino"));
        anamnesis.addAvailableItem(new StageItem("Profissão", "Pedreiro"));
        anamnesis.addAvailableItem(new StageItem("QP", "Dor de cabeça"));
        anamnesis.addAvailableItem(new StageItem("HDA", "Paciente vem ao consultório com queixa de dor de cabeça há 3 dias, de início súbito, unilateral. Refere piora da dor ao decúbito"));
        anamnesis.addAvailableItem(new StageItem("ISDAS", "SP"));
        anamnesis.addAvailableItem(new StageItem("HMP", "Nega comorbidades",new String[]{"comorbidades","doenças prévias","medicações em uso","MUC"}));
        anamnesis.addAvailableItem(new StageItem("HMF", "Nega doenças na família"));
        anamnesis.addAvailableItem(new StageItem("HFS", "Nega tabagismo. Etilista crônico"));
        anamnesis.addItemSummaryName("Nome");
        anamnesis.addItemSummaryName("Idade");
        anamnesis.addItemSummaryName("Sexo");
        anamnesis.addItemSummaryName("QP");
        anamnesis.addItemSummaryName("HDA");

        StageBean physicalExam = new StageBean();
        physicalExam.addAvailableItem(new StageItem("SSVV","PA: 120 / 80 mmHg, TA: 36 ºC, FC: 80 bpm, FR 22 irpm",new String[]{"sinais vitas","sinais","pressão","temperatura","frequência"}));

        StageBean complementaryExams = new StageBean();
        complementaryExams.addAvailableItem(new StageItem("RX de tórax","Sem alterações, correlacionar com a clínica",new String[]{"raio x de torax","radiografia de torax"}));

        return new ClinicalCase(anamnesis, null, physicalExam, complementaryExams);

    }


    public static int getStep() {
        return scene.getStep();
    }

    public static String askItem(String info) {
        return scene.askItem(info);
    }

    public static String getStageSummary() {
        return scene.getStageSummary();
    }

    public static String getStageName() {
        return scene.getStageName();
    }

    public static ArrayList<String> nameAskedFoundItems () {
        return scene.nameAskedFoundItems();
    }

    public static ArrayList<String> nameNotFoundItems () {return scene.nameNotFoundItems();}

    public static String findAskedItemValue (String itemName){
        return scene.findAskedItemValue(itemName);
    }

    public static void setStagePos(int stagePos) {scene.setStagePos(stagePos);}

    public static void setScene (Scene scene){
        MainActivity.scene = scene;
    }
}
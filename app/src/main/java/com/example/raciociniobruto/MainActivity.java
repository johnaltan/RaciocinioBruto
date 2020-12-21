package com.example.raciociniobruto;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Scene scene;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Anamnesis anamnesis = new Anamnesis("Anamnese",
                new StageItem("Nome","JMC"),
                new StageItem("Idade","56"),
                new StageItem("Sexo", "Masculino"),
                new StageItem("Profissão","Pedreiro"),
                new StageItem("QP","Dor de cabeça") ,
                new StageItem("HDA","Paciente vem ao consultório com queixa de dor de cabeça há 3 dias, de início súbito, unilateral. Refere piora da dor ao decúbito"),
                new StageItem("ISDAS","SP"),
                new StageItem("HMP","Nega comorbidades"),
                new StageItem("HMF","Nega doenças na família"),
                new StageItem("HFS","Nega tabagismo. Etilista crônico"));

        this.scene = new Scene(new ClinicalCase(anamnesis,null, null, null));
    }


    public static void nextStep() {
        scene.nextStep();
    }


    public static void nextStage() {
        scene.nextStage();
    }


    public static int getStep() {
        return scene.getStep();
    }


    public static String askInfo(String info) {
        return scene.askInfo(info);
    }


    public static ArrayList<String> getInfoOptions() {
        return scene.getInfoOptions();
    }


    public static String getStageSummary() {
        return scene.getStageSummary();
    }

    public static String getStageName() {
        return scene.getStageName();
    }
}
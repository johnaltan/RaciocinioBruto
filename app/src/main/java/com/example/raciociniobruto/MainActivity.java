package com.example.raciociniobruto;

import android.os.Bundle;

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

        this.scene = new Scene(new ClinicalCase(anamnesis,null, new PhysicalExam(), null));
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


    public static ArrayList<String> nameInfoOptions() {
        return scene.nameInfoOptions();
    }


    public static String getStageSummary() {
        return scene.getStageSummary();
    }

    public static String getStageName() {
        return scene.getStageName();
    }

    public static ArrayList<String> nameAskedInfos () {
        return scene.nameAskedInfos();
    }

    public static ArrayList<StageItem> getAskedItems (){
        return scene.getStageItems();
    }

    public static void setStagePos(int stagePos) {scene.setStagePos(stagePos);}
}
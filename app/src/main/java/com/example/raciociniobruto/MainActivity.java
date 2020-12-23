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

            ClinicalCase clinicalCase = TESTgenerateClinicalCase();

            ArrayList<ClinicalCase> clinicalCases = new ArrayList<ClinicalCase>();
            clinicalCases.add(clinicalCase);
            ClinicalCaseFileTransfer transfer = new ClinicalCaseFileTransfer("clinicalCases.json",this);

            //transfer.sendCases(clinicalCases);

            /*ArrayList<ClinicalCase> readedCases = transfer.loadCases();
            clinicalCase = readedCases.get(1);*/



            this.scene = new Scene(clinicalCase);
        }


    }

    private ClinicalCase TESTgenerateClinicalCase (){
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
        anamnesis.addItemSummaryName("QP");
        anamnesis.addItemSummaryName("HDA");

        Stage physicalExam = new Stage("Exame Físico");
        physicalExam.addAvailableItem(new StageItem("SSVV","PA: 120 / 80 mmHg, TA: 36 ºC, FC: 80 bpm, FR 22 irpm",new String[]{"sinais vitas","sinais"}));

        Stage complementaryExams = new Stage("Exames complementares");
        complementaryExams.addAvailableItem(new StageItem("RX de tórax","Sem alterações, correlacionar com a clínica",new String[]{"raio x de torax","radiografia de torax"}));

        return new ClinicalCase(anamnesis, null, physicalExam, complementaryExams);

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
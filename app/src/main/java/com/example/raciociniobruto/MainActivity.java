package com.example.raciociniobruto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;

import androidx.core.view.MotionEventCompat;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private static final int PICK_INFO = 3;
    TextView txtContent;
    TextView txtTitle;
    TextView txtSummary;
    TextView txtScore;
    String outputText;
    RecyclerView rv;
    private StageItemAdapter stageItemAdapter;

    private static Scene scene;

    private ArrayList<ClinicalCase> clinicalCases;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

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

        gestureDetector = new GestureDetector(this, new MyGestureDetector());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };

        findViewById(R.id.button_stage_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.nextStage();
                updateViews();
            }
        });

        findViewById(R.id.button_stage_previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.previousStage();
                updateViews();
            }
        });

        findViewById(R.id.button_stage_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                startActivityForResult(intent,PICK_INFO);
            }
        });

        txtContent = (TextView) findViewById(R.id.txt_stage_content);
        txtSummary = (TextView) findViewById(R.id.txt_stage_summary);
        txtScore = (TextView) findViewById(R.id.txt_stage_score);
        txtTitle = (TextView) findViewById(R.id.txt_stage_title);

        rv = (RecyclerView) findViewById(R.id.recycler_view_stage);
        rv.setOnTouchListener(gestureListener);

        updateViews();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.PICK_INFO) {

            updateViews();
        }
    }



    private void updateViews(){

        txtSummary.setText("Resumo: " + MainActivity.getStageSummary());
        txtScore.setText("Passos dados: " + String.valueOf(MainActivity.getStep()) + "\nDisponível: " + String.valueOf(MainActivity.getGlobalAvailableItemsAmount()));

        txtTitle.setText(MainActivity.getStageName());
        outputText = new String();

        ArrayList<String> namesAsked = MainActivity.nameAskedFoundItems();
        if (MainActivity.nameNotFoundItems().size() > 0){
            outputText += "\nInexistentes: ";
            namesAsked = MainActivity.nameNotFoundItems();
            for (String i : namesAsked) outputText += i+", ";
        }
        if(outputText.contains(",")) outputText = outputText.substring(0,outputText.lastIndexOf(",")) + ".";

        txtContent.setText(outputText);

        stageItemAdapter= new StageItemAdapter(MainActivity.getAskedFoundItems());
        rv.setAdapter(stageItemAdapter);
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


        StageBean physicalExam = new StageBean();
        physicalExam.addAvailableItem(new StageItem("SSVV","PA: 120 / 80 mmHg, TA: 36 ºC, FC: 80 bpm, FR 22 irpm",new String[]{"sinais vitas","sinais","pressão","temperatura","frequência"}));

        StageBean complementaryExams = new StageBean();
        complementaryExams.addAvailableItem(new StageItem("RX de tórax","Sem alterações, correlacionar com a clínica",new String[]{"raio x de torax","radiografia de torax"}));

        return new ClinicalCase(anamnesis, null, physicalExam, complementaryExams);

    }

    public static int getStep() {
        return scene.getStep();
    }

    public static ArrayList<StageItem> askItem(String info) {
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

    public static void nextStage() {
        scene.nextStage();
    }
    public static void previousStage() {
        scene.previousStage();
    }

    public static void setScene (Scene scene){
        MainActivity.scene = scene;
    }

    public static ArrayList<StageItem> getAskedFoundItems(){
        return scene.getAskedFoundItems();
    }

    public static ArrayList<StageItem> getNotFoundItems(){
        return scene.getNotFoundItems();
    }

    public static int getGlobalAvailableItemsAmount() {return scene.getGlobalAvailableItemsAmount();}

    public static void saveTempFoundItemsIndexes(ArrayList<Integer> indexesToSave){
        scene.saveTempFoundItemsIndexes(indexesToSave);
    }

    class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                // right to left swipe
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    MainActivity.nextStage();
                    updateViews();
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    MainActivity.previousStage();
                    updateViews();
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }
}
package com.example.raciociniobruto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {
    TextView textView;
    private Scene scene;

    public FirstFragment() {
        this.scene = new Scene();
        Anamnesis anamnesis = new Anamnesis(
                new StageItem("Nome","JMC"),
                new StageItem("Idade","56"),
                new StageItem("Sexo", "Masculino"),
                new StageItem("Profissão","Pedreiro"),
                new StageItem("QP","Dor de cabeça") ,
                new StageItem("HDA","Paciente vem ao consultório com queixa de dor de cabeça há 3 dias, de início súbito, unilateral. Refere piora da dor ao decúbito"),
                new StageItem("ISDAS","SP"),
                new StageItem("HMP","Nega comorbidades"),
                new StageItem("HMF","Familia ok"),
                new StageItem("HFS","Nega tabagismo. Etilista crônico"));

        this.scene.loadCase(new ClinicalCase(anamnesis,null, null, null));
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textview_first);
        textView.setText(this.scene.getStageSummary());

        view.findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavHostFragment.findNavController(FirstFragment.this)
                //        .navigate(R.id.action_FirstFragment_to_SecondFragment);



            }
        });
        view.findViewById(R.id.button_diagnostic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        view.findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
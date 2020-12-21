package com.example.raciociniobruto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class AnamnesisFragment extends Fragment {
    TextView textView;
    private Scene scene;
    String outputText;
    int options;
    SharedViewModel viewModel;

    public AnamnesisFragment() {
        this.scene = new Scene();
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
        this.options = 0;
        this.scene.loadCase(new ClinicalCase(anamnesis,null, null, null));
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.anamnesis_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textview_first);
        outputText = this.scene.getStageSummary();
        textView.setText(outputText);


        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getInfoAdded().observe(getViewLifecycleOwner(),s -> {
            outputText += "\nSolicitados:\n\n";
            for (String i : s) outputText += i + ": " + scene.askInfo(i) + "\n";
            textView.setText(outputText);
        });


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
                /*outputText = scene.getStageSummary();
                textView.setText(outputText);
                options = 0;*/
            }
        });
        view.findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*switch (options){
                    case 0:
                        outputText += "HMP: " + scene.askInfo("HMP") + "\n";
                        options++;
                        break;
                    case 1:
                        outputText += "HMF: " + scene.askInfo("HMF") + "\n";
                        options++;
                        break;
                    case 2:
                        outputText += "HFS: " + scene.askInfo("HFS") + "\n";
                        options++;
                        break;
                }
                textView.setText(outputText);*/

                viewModel.setTitle(scene.getStageName());

                NavHostFragment.findNavController(AnamnesisFragment.this)
                        .navigate(R.id.action_AnamnesisFragment_to_InfoFragment);



            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
      //  textView.setText("Voltei");

    }
}

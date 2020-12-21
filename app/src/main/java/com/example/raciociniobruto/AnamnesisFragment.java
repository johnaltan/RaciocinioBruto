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

public class AnamnesisFragment extends Fragment {
    TextView txtContent;
    TextView txtTitle;
    String outputText;

    //SharedViewModel viewModel;

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
        MainActivity.setStagePos(0);

        txtContent = (TextView) view.findViewById(R.id.txt_anamnesis_content);
        txtTitle = (TextView) view.findViewById(R.id.txt_anamnesis_title);
        txtTitle.setText(MainActivity.getStageName());
        outputText = MainActivity.getStageSummary();


        //viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

/*        viewModel.getInfoAdded().observe(getViewLifecycleOwner(),s -> {
            outputText += "\nSolicitados:\n\n";
            for (String i : s) outputText += i + ": " + MainActivity.askInfo(i) + "\n";
            outputText += "\nPassos dados: " + String.valueOf(MainActivity.getStep());
            txtContent.setText(outputText);
        });*/
        outputText += "\nSolicitados:\n\n";
        for (StageItem i : MainActivity.getAskedItems()) outputText += i.getName() + ": " + i.getValue()+"\n";
        txtContent.setText(outputText);


        view.findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.nextStage();
                NavHostFragment.findNavController(AnamnesisFragment.this)
                        .navigate(R.id.action_AnamnesisFragment_to_PhysicalExamFragment);




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

             //   viewModel.setTitle(MainActivity.getStageName());

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

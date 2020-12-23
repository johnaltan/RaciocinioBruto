package com.example.raciociniobruto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

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

        outputText += "\nSOLICITADOS:\nEncontrados:\n\n";
        ArrayList<String> namesAsked = MainActivity.nameAskedFoundItems();
        for (String i : namesAsked) outputText += i + ": " + MainActivity.findAskedItemValue(i)+"\n";
        if (MainActivity.nameNotFoundItems().size() > 0){
            outputText += "\nInexistentes:\n";
            namesAsked = MainActivity.nameNotFoundItems();
            for (String i : namesAsked) outputText += i+"\n";

        }
        outputText += "\nPassos dados: " + String.valueOf(MainActivity.getStep());
        txtContent.setText(outputText);


        view.findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AnamnesisFragment.this)
                        .navigate(R.id.action_AnamnesisFragment_to_PhysicalExamFragment);
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

             //   viewModel.setTitle(MainActivity.getStageName());

                NavHostFragment.findNavController(AnamnesisFragment.this)
                        .navigate(R.id.action_AnamnesisFragment_to_InfoFragment);
            }
        });
    }
}

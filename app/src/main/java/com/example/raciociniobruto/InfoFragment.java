package com.example.raciociniobruto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class InfoFragment extends Fragment {
    TextView txtContent;
    TextView txtTitle;
    EditText editTextOption;
    String stringTxtContent;
    String stringAddedOptions;
    String stringTxtTitle;
    ArrayList<String> infoAdded;

    SharedViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.info_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stringTxtContent = new String();
        stringAddedOptions = new String();
        infoAdded = new ArrayList<String>();

        txtContent = (TextView) view.findViewById(R.id.txt_content);
        txtTitle = (TextView) view.findViewById(R.id.txt_title);
        editTextOption = (EditText) view.findViewById(R.id.editTextOption);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getTitle().observe(getViewLifecycleOwner(),s -> { txtTitle.setText("Solicitar info: " + s);});


        view.findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                viewModel.setInfoAdded(infoAdded);

              //  NavHostFragment.findNavController(InfoFragment.this)
              //          .navigate(R.id.action_InfoFragment_to_AnamnesisFragment);

                NavHostFragment.findNavController(InfoFragment.this)
                        .navigateUp();
            }
        });

        view.findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = editTextOption.getText().toString();

                infoAdded.add(i);
                stringTxtContent += i + "\n";
                txtContent.setText(stringTxtContent);

                editTextOption.setText("");
                editTextOption.requestFocus();


            }
        });

    }

}
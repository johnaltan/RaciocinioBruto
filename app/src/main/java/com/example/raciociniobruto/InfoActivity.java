package com.example.raciociniobruto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    TextView txtContent;
    TextView txtTitle;
    EditText editTextOption;
    String stringTxtContent;
    String stringAddedOptions;
    String stringTxtTitle;
   // ArrayList<String> infoAdded;

    SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        stringTxtContent = new String();
        stringAddedOptions = new String();
      //  infoAdded = new ArrayList<String>();

        txtContent = (TextView) findViewById(R.id.txt_content);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        editTextOption = (EditText) findViewById(R.id.editTextOption);

       // viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        //viewModel.getTitle().observe(getViewLifecycleOwner(),s -> { txtTitle.setText("Solicitar info: " + s);});

        txtTitle.setText("Solicitar info: " +MainActivity.getStageName());
        ArrayList<String> namesAsked = MainActivity.nameAskedFoundItems();
        if (namesAsked.size() > 0) {
            stringTxtContent += "Encontrados:\n";
            for (String s : namesAsked) stringTxtContent += s + "\n";
        }
        if (MainActivity.nameNotFoundItems().size() > 0){
            stringTxtContent += "\nInexistentes:\n";
            for (String s : MainActivity.nameNotFoundItems()) stringTxtContent += s + "\n";
        }
        stringTxtContent += "\n\nRecém registradas:\n";
        txtContent.setText(stringTxtContent);

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            //    viewModel.setInfoAdded(infoAdded);

             finish();
            }
        });

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = editTextOption.getText().toString();

               // infoAdded.add(i);
                StageItem item = MainActivity.askItem(i);
                if(item == null) Toast.makeText(view.getContext(),"Info não encontrada.", Toast.LENGTH_LONG).show();
                else Toast.makeText(view.getContext(),"Info encontrada e registrada como: " + item.getName() + ".", Toast.LENGTH_LONG).show();
                stringTxtContent += i + "\n";
                txtContent.setText(stringTxtContent);

                editTextOption.setText("");
                editTextOption.requestFocus();


            }
        });

    }

}
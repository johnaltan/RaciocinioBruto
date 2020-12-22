package com.example.raciociniobruto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhysicalExamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhysicalExamFragment extends Fragment {
    TextView txtContent;
    TextView txtTitle;
    String outputText;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PhysicalExamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhysicalExamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhysicalExamFragment newInstance(String param1, String param2) {
        PhysicalExamFragment fragment = new PhysicalExamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_physical_exam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity.setStagePos(1);

        txtContent = (TextView) view.findViewById(R.id.txt_physicalExam_content);
        txtTitle = (TextView) view.findViewById(R.id.txt_physicalExam_title);
        txtTitle.setText(MainActivity.getStageName());
        outputText = MainActivity.getStageSummary();
        txtContent.setText(outputText);

        outputText += "\nSolicitados:\n\n";
        for (StageItem i : MainActivity.getAskedItems()) outputText += i.getName() + ": " + i.getValue()+"\n";
        outputText += "\nPassos dados: " + String.valueOf(MainActivity.getStep());
        txtContent.setText(outputText);

        view.findViewById(R.id.button_physicalExam_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PhysicalExamFragment.this)
                        .navigate(R.id.action_PhysicalExamFragment_to_InfoFragment);
            }
        });

        view.findViewById(R.id.button_physicalExam_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PhysicalExamFragment.this)
                        .navigate(R.id.action_PhysicalExamFragment_to_ComplementaryExamsFragment);
            }
        });
    }
}
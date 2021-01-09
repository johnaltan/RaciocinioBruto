package com.example.raciociniobruto;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;


public class StageAdapter extends PagerAdapter {

    Context context;
    Scene scene;

    public StageAdapter(Context context, Scene scene) {
        this.context = context;
        this.scene = scene;
    }

    @Override
    public int getCount() {
        return this.scene.getStages().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o==view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Stage[] stages = scene.getStages();

        ConstraintLayout stageConstraintLayout = (ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.stage_page, null);

        TextView txtContent = (TextView) stageConstraintLayout.findViewById(R.id.txt_stage_content);
        TextView txtSummary = (TextView) stageConstraintLayout.findViewById(R.id.txt_stage_summary);
        TextView txtScore = (TextView) stageConstraintLayout.findViewById(R.id.txt_stage_score);
        TextView txtTitle = (TextView) stageConstraintLayout.findViewById(R.id.txt_stage_title);

        RecyclerView rv = (RecyclerView) stageConstraintLayout.findViewById(R.id.recycler_view_stage);

        txtSummary.setText("Resumo: " + stages[position].getSummary());
        txtScore.setText("Passos dados: " + String.valueOf(scene.getStep()) + "\nDisponível: " + String.valueOf(scene.getGlobalAvailableItemsAmount()));

        txtTitle.setText(stages[position].getName());
        String outputText = new String();

        ArrayList<String> namesAsked = stages[position].nameAskedFoundItems();
        if (stages[position].nameNotFoundItems().size() > 0){
            outputText += "Inexistentes: ";
            namesAsked = stages[position].nameNotFoundItems();
            for (String i : namesAsked) outputText += i+", ";
        }
        if(outputText.contains(",")) outputText = outputText.substring(0,outputText.lastIndexOf(",")) + ".";

        txtContent.setText(outputText);

        rv.setAdapter(new StageItemAdapter(stages[position].getAskedFoundItems()));


        container.addView(stageConstraintLayout);
        return stageConstraintLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }

    @Override
    public int getItemPosition(Object object) { //an inefficient, but sufficient way to update on data set changed
        return POSITION_NONE;
    }

}

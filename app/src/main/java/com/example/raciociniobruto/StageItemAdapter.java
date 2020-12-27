package com.example.raciociniobruto;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class StageItemAdapter extends RecyclerView.Adapter<StageItemAdapter.StageItemViewHolder> {

    private ArrayList<StageItem> stageItems;

    public StageItemAdapter (ArrayList<StageItem> stageItems){

        this.stageItems = stageItems;
    }

    @NonNull
    @Override
    public StageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stage_item,parent,false);
        return new StageItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StageItemViewHolder holder, int position) {
        StageItem stageItem = this.stageItems.get(position);
        holder.bind(stageItem);
    }

    @Override
    public int getItemCount() {
        return stageItems.size();
    }

    class StageItemViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        LinearLayout linearLayout;
        Context context;

        public StageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //this.txtContent = (TextView) itemView.findViewById(R.id.txt_stage_item);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txt_title_stage_item);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout_stage_item);
            this.context = itemView.getContext();

        }

        public void bind (StageItem stageItem){
            txtTitle.setText(stageItem.getName());


            if(stageItem.getName().equalsIgnoreCase("rosto")) {
                ImageView imageContent = new ImageView(this.context);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(2,2,2,2);
                imageContent.setLayoutParams(layoutParams);
                imageContent.setAdjustViewBounds(true);
                linearLayout.addView(imageContent);
                String baseRosto = stageItem.getValue();
                byte[] decodedString = Base64.decode(baseRosto, Base64.DEFAULT);
                Bitmap decodeBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);


                imageContent.setImageBitmap(decodeBitmap);
            }
            else {
                TextView txtContent = new TextView(this.context);
                txtContent.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(2,2,2,2);
                txtContent.setLayoutParams(layoutParams);
                linearLayout.addView(txtContent);
                txtContent.setText(stageItem.getValue());
            }



        }
            

    }
}

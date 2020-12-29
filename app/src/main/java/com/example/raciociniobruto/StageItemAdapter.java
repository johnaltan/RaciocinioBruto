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
        TextView txtContent;
        ImageView imgContent;

        public StageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txt_title_stage_item);
            this.txtContent = (TextView) itemView.findViewById(R.id.txt_stage_item);
            this.imgContent = (ImageView) itemView.findViewById(R.id.img_stage_item);


        }

        public void bind (StageItem stageItem){
            txtTitle.setText(stageItem.getName());


            if(stageItem.getValueIsImage()) {

                String baseImage = stageItem.getValue();
                byte[] decodedString = Base64.decode(baseImage, Base64.DEFAULT);
                Bitmap decodeBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                imgContent.setImageBitmap(decodeBitmap);

                txtContent.setVisibility(View.GONE);
                imgContent.setVisibility(View.VISIBLE);
            }
            else {
                txtContent.setText(stageItem.getValue());
            }



        }
            

    }
}

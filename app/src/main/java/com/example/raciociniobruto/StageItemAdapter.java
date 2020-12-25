package com.example.raciociniobruto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        TextView txtContent;
        TextView txtTitle;

        public StageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtContent = (TextView) itemView.findViewById(R.id.txt_stage_item);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txt_title_stage_item);
        }

        public void bind (StageItem stageItem){
            txtTitle.setText(stageItem.getName());
            txtContent.setText(stageItem.getValue());

        }

    }
}

package com.example.house_pe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.house_pe.Models.HouseModel;
import com.example.house_pe.R;

import java.util.ArrayList;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ViewHolder> {
    Context context;
    ArrayList<HouseModel> houseModels;

    public HouseAdapter(Context context, ArrayList<HouseModel> houseModels) {
        this.context = context;
        this.houseModels = houseModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.houseId.setText(String.valueOf(houseModels.get(position).getHouseId()));
        holder.houseNo.setText(houseModels.get(position).getHouseNo());
        holder.houseOwner.setText(houseModels.get(position).getHouseOwnerName());
        holder.housePrice.setText(String.format("%,.2f",houseModels.get(position).getHousePrice()));
        holder.houseNoOfRoom.setText(String.valueOf(houseModels.get(position).getNoOfRoom()));

    }

    @Override
    public int getItemCount() {
        return houseModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView houseId, houseNo, houseOwner, houseNoOfRoom,housePrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            houseId = itemView.findViewById(R.id.main_houseId);
            houseNo = itemView.findViewById(R.id.main_houseNo);
            houseOwner = itemView.findViewById(R.id.main_houseOwner);
            houseNoOfRoom = itemView.findViewById(R.id.main_noOfRoom);
            housePrice = itemView.findViewById(R.id.main_price);
        }
    }
}

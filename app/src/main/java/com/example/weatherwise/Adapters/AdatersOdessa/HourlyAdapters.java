package com.example.weatherwise.Adapters.AdatersOdessa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwise.Domains.DomainsOdessa.Hourly;
import com.example.weatherwise.R;

import java.util.ArrayList;

public class HourlyAdapters extends RecyclerView.Adapter<HourlyAdapters.viewHolder> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapters(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HourlyAdapters.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_odessa,parent,false);
        context=parent.getContext();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapters.viewHolder holder, int position) {
        holder.TextViewHour.setText(items.get(position).getHour());
        holder.TextViewTemp.setText(items.get(position).getTemp()+"°");


        int drawableRecourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableRecourceId)
                .into(holder.ImageViewPic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView TextViewHour,TextViewTemp;
        ImageView ImageViewPic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewHour =itemView.findViewById(R.id.TextViewHour);
            TextViewTemp= itemView.findViewById(R.id.TextViewTemp);
            ImageViewPic = itemView.findViewById(R.id.ImageViewPic);

        }
    }
}

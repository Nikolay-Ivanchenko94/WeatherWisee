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
import com.example.weatherwise.Domains.FutureDomain;
import com.example.weatherwise.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHoder> {
    ArrayList<FutureDomain> items;
    Context context;

    public FutureAdapter(ArrayList<FutureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inFlate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_future,parent,false);
        context= parent.getContext();
        return new viewHoder(inFlate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        holder.TextViewDay.setText(items.get(position).getDay());
        holder.TextViewStatus.setText(items.get(position).getStatus());
        holder.TextViewLow.setText(items.get(position).getLowTemp()+"°");
        holder.TextViewHigh.setText(items.get(position).getHighTemp()+"°");


        int drawableRecourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableRecourceId)
                .into(holder.ImageViewPicFutureOdessa);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        TextView TextViewDay,TextViewStatus,TextViewLow,TextViewHigh;
        ImageView ImageViewPicFutureOdessa;

        public viewHoder(@NonNull View itemView) {
            super(itemView);


            TextViewDay = itemView.findViewById(R.id.TextViewDay);
            TextViewStatus= itemView.findViewById(R.id.TextViewStatus);
            TextViewHigh = itemView.findViewById(R.id.TextViewHigh);
            TextViewLow = itemView.findViewById(R.id.TextViewLow);
            ImageViewPicFutureOdessa = itemView.findViewById(R.id.ImageViewPicFuture);




        }
    }
}

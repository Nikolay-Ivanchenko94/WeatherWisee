package com.example.weatherwise.ActivitiesKiev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.weatherwise.Adapters.FutureAdapter;
import com.example.weatherwise.Domains.FutureDomain;
import com.example.weatherwise.R;
import com.example.weatherwise.databinding.ActivityKievBinding;

import java.util.ArrayList;

public class ActivityKiev extends AppCompatActivity {
    ActivityKievBinding binding;

    public RecyclerView recyclerView;

    private RecyclerView.Adapter adapterTomorrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityKievBinding binding = ActivityKievBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.BtnBackMainKiev.setOnClickListener(v -> {Intent intent = new Intent(ActivityKiev.this, ActivityMainKiev.class);
            startActivity(intent);
        });
        getString(R.string.TextViewTomorrow);
        getString(R.string.TextViewRain);
        getString(R.string.TextViewWindy);
        getString(R.string.TextViewHumidity);

        initRecyclerView();


    }

    private void initRecyclerView() {

        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Суб","stormicon","Шторм",10,5));
        items.add(new FutureDomain("Нед","cloudyicon","Хмарно",12,6));
        items.add(new FutureDomain("Пон","windyicon","Вітряно",15,7));
        items.add(new FutureDomain("Вів","sunnyicon","Соняшно",5,2));
        items.add(new FutureDomain("Сер","rainicon","Дощ",0,-4));
        items.add(new FutureDomain("Чет","sunnycloudy","Соняшно-Хмарно",2,-2));
        items.add(new FutureDomain("П'ят","snowicon","Сніг",-5,-10));

        recyclerView=findViewById(R.id.RecylerViewFutureKiev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        adapterTomorrow= new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);


    }
}
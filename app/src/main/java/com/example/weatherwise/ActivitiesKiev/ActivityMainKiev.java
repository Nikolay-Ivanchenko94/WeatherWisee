package com.example.weatherwise.ActivitiesKiev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.ActivitiesOdessa.ActivityMainOdessa;
import com.example.weatherwise.Adapters.HourlyAdapter;
import com.example.weatherwise.Domains.Hourly;
import com.example.weatherwise.R;
import com.example.weatherwise.SettingsActivity.SettingsActivity;
import com.example.weatherwise.databinding.ActivityMainKievBinding;

import java.util.ArrayList;

public class ActivityMainKiev extends AppCompatActivity {

    private RecyclerView.Adapter  adapterHourly;
    private RecyclerView recyclerView;

    ActivityMainKievBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainKievBinding binding = ActivityMainKievBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /// binding.BtnGeolocationKiev.setOnClickListener(v -> ); ///


        binding.BtnSettings.setOnClickListener(v -> {
        Intent intent = new Intent(ActivityMainKiev.this, SettingsActivity.class);
        startActivity(intent);
        });
        getString(R.string.TextViewKiev);
        getString(R.string.TextViewWindy);
        getString(R.string.TextViewTuesday);
        getString(R.string.TextViewRain);
        getString(R.string.TextViewHumidity);

       binding.BtnNext7DaysKiev.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainKiev.this, ActivityKiev.class);
       startActivity(intent);});

       binding.BtnOdessa.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainKiev.this, ActivityMainOdessa.class);
       startActivity(intent);});
       binding.BtnKiev.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainKiev.this, ActivityMainKiev.class);
       startActivity(intent);});
       binding.BtnDnipro.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainKiev.this, ActivityMainDnipro.class);
       startActivity(intent);});


        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly(-3, "14:00", "cloudyicon"));
        items.add(new Hourly(-4, "15:00", "sunnyicon"));
        items.add(new Hourly(-1, "16:00", "iconwindy"));
        items.add(new Hourly(-7, "17:00", "rainicon"));
        items.add(new Hourly(-1, "18:00", "snowicon"));
        items.add(new Hourly(-3, "19:00", "stormicon"));

        recyclerView=findViewById(R.id.RecyclerViewKiev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
package com.example.weatherwise.ActivitiesOdessa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.ActivitiesKiev.ActivityMainKiev;
import com.example.weatherwise.Adapters.HourlyAdapter;
import com.example.weatherwise.Domains.Hourly;
import com.example.weatherwise.R;
import com.example.weatherwise.SettingsActivity.SettingsActivity;
import com.example.weatherwise.databinding.ActivityMainOdessaBinding;

import java.util.ArrayList;

public class ActivityMainOdessa extends AppCompatActivity {
    private RecyclerView.Adapter  adapterHourly;
    private RecyclerView recyclerView;
    ActivityMainOdessaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainOdessaBinding binding = ActivityMainOdessaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerView();

      ///  binding.BtnGeolocationOdessa.setOnClickListener(v -> ); ///



        binding.BtnSettingsOdessa.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainOdessa.this, SettingsActivity.class);
        startActivity(intent);});
        getString(R.string.TextViewOdessa);
        getString(R.string.TextViewWindy);
        getString(R.string.TextViewSaturday);
        getString(R.string.TextViewRain);
        getString(R.string.TextViewHumidity);
        getString(R.string.TextViewYesterday);
        binding.BtnNext7DaysOdessa.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainOdessa.this, ActivityOdessa.class);
        startActivity(intent);
        });
        binding.BtnDnipro.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainOdessa.this, ActivityMainDnipro.class);
        startActivity(intent);
        });
        binding.BtnOdessa.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainOdessa.this, ActivityMainOdessa.class);
        startActivity(intent);});
        binding.BtnKiev.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainOdessa.this, ActivityMainKiev.class);
        startActivity(intent);});
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly(-3, "14:00", "cloudyicon"));
        items.add(new Hourly(-4, "15:00", "sunnyicon"));
        items.add(new Hourly(-1, "16:00", "iconwindy"));
        items.add(new Hourly(-7, "17:00", "rainicon"));
        items.add(new Hourly(-1, "18:00", "snowicon"));
        items.add(new Hourly(-3, "19:00", "stormicon"));

        recyclerView=findViewById(R.id.RecyclerViewOdessa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
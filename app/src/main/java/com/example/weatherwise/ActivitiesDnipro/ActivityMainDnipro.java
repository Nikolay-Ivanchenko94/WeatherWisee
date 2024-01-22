package com.example.weatherwise.ActivitiesDnipro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherwise.ActivitiesKiev.ActivityMainKiev;
import com.example.weatherwise.ActivitiesOdessa.ActivityMainOdessa;
import com.example.weatherwise.ActivitiesDnipro.ActivityDnipro.ActivityDnipro;
import com.example.weatherwise.Adapters.HourlyAdapter;
import com.example.weatherwise.Domains.Hourly;
import com.example.weatherwise.R;
import com.example.weatherwise.SettingsActivity.SettingsActivity;
import com.example.weatherwise.databinding.ActivityMainDniproBinding;
import com.example.weatherwise.databinding.ActivityMapBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ActivityMainDnipro extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    private String CITY = "";




    ActivityMainDniproBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainDniproBinding binding = ActivityMainDniproBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerview();


        binding.BtnGeolocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainDnipro.this, ActivityMapBinding.class);
                startActivity(intent);


            }
        });
        binding.BtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainDnipro.this, SettingsActivity.class);
                startActivity(intent);

            }
        });
        binding.TextViewSunnyDnipro.setText("Соняшно");
        TextView TextViewSunnyDnipro = binding.TextViewSunnyDnipro;
        String SunnyDnipro = binding.TextViewSunnyDnipro.getText().toString();
        binding.TextViewSaturdayDnipro.setText("Субота 30 груня | 12:00");
        TextView TextViewSaturdayDnipro = binding.TextViewSaturdayDnipro;
        String SaturdayDnipro = binding.TextViewSaturdayDnipro.getText().toString();
        binding.TextViewDegreeDnipro.setText("6");
        TextView TextViewDegreeDnipro = binding.TextViewDegreeDnipro;
        String DegreeDnipro = binding.TextViewDegreeDnipro.getText().toString();
        binding.TextViewDegreeRainDnipro.setText("72%");
        TextView TextiewDegreeRainDnipro = binding.TextViewDegreeRainDnipro;
        String DegreeRainDnipro = binding.TextViewDegreeRainDnipro.getText().toString();
        binding.TextViewRainDnipro.setText("Дощ");
        TextView TextViewRainDnipro = binding.TextViewRainDnipro;
        String RainDnipro = binding.TextViewRainDnipro.getText().toString();
        binding.TextViewDegreeWindyDnipro.setText("3 M/C");
        TextView TextViewDegreeWindyDnipro = binding.TextViewDegreeWindyDnipro;
        String DegreeWindyDnipro = binding.TextViewDegreeWindyDnipro.getText().toString();
        binding.TextViewWindyDnipro.setText("Вітер");
        TextView TextViewWindyDnipro = binding.TextViewWindyDnipro;
        String WindyDnipro = binding.TextViewWindyDnipro.getText().toString();
        binding.TextViewDegreeHumidityDnipro.setText("79%");
        TextView TextViewDegreeHumidityDnipro = binding.TextViewDegreeHumidityDnipro;
        String DegreeHumidityDnipro = binding.TextViewDegreeHumidityDnipro.getText().toString();
        binding.TextViewHumidityDnipro.setText("Вологість");
        TextView TextViewHumidityDnipro = binding.TextViewHumidityDnipro;
        String HumidityDnipro = binding.TextViewHumidityDnipro.getText().toString();
        binding.TextViewYesterday.setText("Сьогодні");
        TextView TextViewYesterday = binding.TextViewYesterday;
        String Yesterday = binding.TextViewYesterday.getText().toString();


        binding.BtnNext7Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMainDnipro.this, ActivityDnipro.class);
                startActivity(intent);
            }
        });
        binding.BtnDnipro.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainDnipro.this,ActivityMainDnipro.class);
            startActivity(intent);
        });
        binding.BtnOdessa.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainDnipro.this,ActivityMainOdessa.class);
            startActivity(intent);
        });
        binding.BtnKiev.setOnClickListener(v -> {Intent intent = new Intent(ActivityMainDnipro.this, ActivityMainKiev.class);
        startActivity(intent);});
    }




    private void initRecyclerview() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly(2, "17:00", "cloudyicon"));
        items.add(new Hourly(4, "16:00", "sunnyicon"));
        items.add(new Hourly(1, "15:00", "iconwindy"));
        items.add(new Hourly(7, "14:00", "rainicon"));
        items.add(new Hourly(1, "13:00", "snowicon"));
        items.add(new Hourly(3, "12:00", "stormicon"));

        recyclerView=findViewById(R.id.RecyClerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
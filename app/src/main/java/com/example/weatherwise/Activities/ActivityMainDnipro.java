package com.example.weatherwise.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherwise.ActivityMainDnipro.ActivityDnipro;
import com.example.weatherwise.Adapters.HourlyAdapter;
import com.example.weatherwise.Domains.Hourly;
import com.example.weatherwise.R;
import com.example.weatherwise.SettingsActivity.SettingsActivity;
import com.example.weatherwise.databinding.ActivityMainDniproBinding;

import java.util.ArrayList;

public class ActivityMainDnipro extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

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
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly(2, "17:00", "cloudy"));
        items.add(new Hourly(4, "16:00", "sun"));
        items.add(new Hourly(1, "15:00", "wind"));
        items.add(new Hourly(7, "14:00", "rainy"));
        items.add(new Hourly(1, "13:00", "snow"));
        items.add(new Hourly(3, "12:00", "storm"));

        recyclerView=findViewById(R.id.RecyClerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
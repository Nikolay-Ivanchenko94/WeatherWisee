package com.example.weatherwise.ActivityMainDnipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherwise.R;
import com.example.weatherwise.databinding.ActivityDniproBinding;

public class ActivityDnipro extends AppCompatActivity {
    ActivityDniproBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDniproBinding binding = ActivityDniproBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.BtnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDnipro.this, ActivityMainDnipro.class);
                startActivity(intent);
            }
        });
        binding.TextViewTomorrowDnipro.setText("Завтра");
        TextView TextViewTomorrowDnipro = binding.TextViewTomorrowDnipro;
        String TomorrowDnipro = binding.TextViewTomorrowDnipro.getText().toString();
        binding.TextViewDegreeMain.setText("6");
        TextView TextViewDegreeMain = binding.TextViewDegreeMain;
        String DegreeMain = binding.TextViewDegreeMain.getText().toString();
        binding.TextViewMostlyCloudyMain.setText("Переважно хмарно");
        TextView TextViewMostlyCloudyMain = binding.TextViewMostlyCloudyMain;
        String MostlyCloudyMain = binding.TextViewMostlyCloudyMain.getText().toString();
        binding.TextViewDegreeRain.setText("72%");
        TextView TextViewDegreeRain = binding.TextViewDegreeRain;
        String DegreeRain = binding.TextViewDegreeRain.getText().toString();
        binding.TextViewRainMainDnipro.setText("Дощ");
        TextView TextViewRainMainDnipro = binding.TextViewRainMainDnipro;
        String RainMainDnipro = binding.TextViewRainMainDnipro.getText().toString();
        binding.TextViewWindyDegree.setText("3 M/C");
        TextView TextViewWindyDegree = binding.TextViewWindyDegree;
        String WindyDegree = binding.TextViewWindyDegree.getText().toString();
        binding.TextViewWindyMain.setText("Вітер");
        TextView TextViewWindyMain = binding.TextViewWindyMain;
        String WindyMain = binding.TextViewWindyMain.getText().toString();
        binding.TextViewHumidityDegreeMain.setText("79%");
        TextView TextViewHumidityDegreeMain = binding.TextViewHumidityDegreeMain;
        String HumidityDegreeMain = binding.TextViewHumidityDegreeMain.getText().toString();
        binding.TextViewHumidityMainDnipro.setText("Вологість");
        TextView TextViewHumidityMainDnipro = binding.TextViewHumidityMainDnipro;
        String HumidityMainDnipro = binding.TextViewHumidityMainDnipro.getText().toString();

    }
}
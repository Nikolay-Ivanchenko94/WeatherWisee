package com.example.weatherwise.ActivitiesDnipro.ActivityDnipro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.Adapters.FutureAdapter;
import com.example.weatherwise.Domains.FutureDomain;
import com.example.weatherwise.R;
import com.example.weatherwise.databinding.ActivityDniproBinding;

import java.util.ArrayList;

public class ActivityDnipro extends AppCompatActivity {
    ActivityDniproBinding binding;
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;
    String API_KEY =  "13c3af20c3e545d79f3125407240401";
    String City = "Dnipro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDniproBinding binding = ActivityDniproBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerView();

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



    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

       items.add(new FutureDomain("Суб","stormicon","Шторм",15,8));
        items.add(new FutureDomain("Нед","cloudyicon","Хмарно",10,5));
        items.add(new FutureDomain("Пон","windyicon","Вітряно",7,3));
        items.add(new FutureDomain("Вів","sunnyicon","Соняшно",5,2));
        items.add(new FutureDomain("Сер","rainicon","Дощ",0,-4));
        items.add(new FutureDomain("Чет","sunnycloudy","Соняшно-Хмарно",2,-2));
        items.add(new FutureDomain("П'ят","snowicon","Сніг",-5,-10));




        recyclerView=findViewById(R.id.RecylerViewFuture);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        adapterTomorrow= new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }


}
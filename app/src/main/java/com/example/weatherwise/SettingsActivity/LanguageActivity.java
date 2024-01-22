package com.example.weatherwise.SettingsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.R;
import com.example.weatherwise.databinding.ActivityLanguageBinding;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    ActivityLanguageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLanguageBinding binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BtnBackLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        binding.TextViewLanguageText.setText("Мова");
        binding.TextViewLanguageUsa.setText("American");
        binding.BtnUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("USA");
                Configuration configuration = getBaseContext().getResources().getConfiguration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(LanguageActivity.this, ActivityMainDnipro.class);
                startActivity(intent);
            }
        });
        binding.BtnPoland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("PL");
                Configuration configuration = getBaseContext().getResources().getConfiguration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(LanguageActivity.this,ActivityMainDnipro.class);
                startActivity(intent);
                getString(R.string.BtnRegistration);
            }
        });


    }
}
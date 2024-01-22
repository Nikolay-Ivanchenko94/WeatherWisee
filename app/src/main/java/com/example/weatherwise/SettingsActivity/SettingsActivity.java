package com.example.weatherwise.SettingsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.LoginActivity.LoginActivity;
import com.example.weatherwise.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingsBinding binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.BtnBackSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ActivityMainDnipro.class);
                startActivity(intent);
            }
        });
        binding.TextViewAccount.setText("Акаунт");
        TextView TextViewAccount = binding.TextViewAccount;
        String Account = binding.TextViewAccount.getText().toString();
        binding.BtnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.TextViewForgotPassword.setText("Восстановити пароль");
        TextView TextViewForgotPassword = binding.TextViewForgotPassword;
        String ForgotPassword = binding.TextViewForgotPassword.getText().toString();
        binding.BtnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ResetPasswordActivity.class);
                startActivity(intent);

            }
        });
        binding.TextViewLanguage.setText("Мова");
        TextView TextViewLanguage = binding.TextViewLanguage;
        String Language = binding.TextViewLanguage.getText().toString();
        binding.BtnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LanguageActivity.class);
                startActivity(intent);

            }
        });
        binding.TextViewLoggout.setText("Вийти");
        TextView TextViewLoggout = binding.TextViewLoggout;
        String Loggout = binding.TextViewLoggout.getText().toString();
        binding.BtnLoggout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
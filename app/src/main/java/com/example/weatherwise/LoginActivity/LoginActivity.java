package com.example.weatherwise.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherwise.RegisterActivity.RegisterActiity;
import com.example.weatherwise.SettingsActivity.SettingsActivity;
import com.example.weatherwise.databinding.ActivityLoginBinding;
import com.example.weatherwise.databinding.ActivityMainDniproBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BtnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ActivityMainDniproBinding.class);
                startActivity(intent);
            }
        });
        binding.TextViewLoginRegistration.setText("Вхід / Реєстрація ");
        TextView  TextViewLoginRegistration = binding.TextViewLoginRegistration;
        String LoginRegistration = binding.TextViewLoginRegistration.getText().toString();
        binding.TextViewEnterEmail.setText("Введіть E-mail");
        TextView TextViewEnterEmail = binding.TextViewEnterEmail;
        String EnterEmai = binding.TextViewEnterEmail.getText().toString();
        binding.EditTextEmail.getText();
        EditText EditTextEmail = binding.EditTextEmail;
        String Email = binding.EditTextEmail.getText().toString();
        binding.TextViewEnterPsw.setText("Введіть  Пароль");
        TextView TextViewEnterPsw = binding.TextViewEnterPsw;
        String EnterPsw = binding.TextViewEnterPsw.getText().toString();
        binding.EditTextPsw.getText();
        EditText EditTextPsw = binding.EditTextPsw;
        String Psw = binding.EditTextPsw.getText().toString();
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(LoginActivity.this,"Введіть E-mail",Toast.LENGTH_LONG).show();
            EditTextEmail.setError("Невірні дані у полі E-mail");
            EditTextEmail.requestFocus();
            if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                Toast.makeText(LoginActivity.this,"Введіть E-mail",Toast.LENGTH_LONG).show();
                EditTextEmail.setError("Невірні дані у полі E-mail");
                EditTextEmail.requestFocus();
                if (TextUtils.isEmpty(Psw)) {
                    Toast.makeText(LoginActivity.this,"Введіть Пароль",Toast.LENGTH_LONG).show();
                    EditTextPsw.setError("Невірні дані у полі Пароль");
                    EditTextPsw.requestFocus();
                    if (Psw.length() < 5 ) {
                        Toast.makeText(LoginActivity.this,"Пароль повинен містити від 5 символів",Toast.LENGTH_LONG).show();
                        EditTextPsw.setError("Надто слабкий пароль");
                        EditTextPsw.requestFocus();
                    }
                }
            }
        }
        binding.ChecBoxLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        binding.TextViewChecBox.setText("Запам'ятати мене");
        TextView TextViewCheckBox = binding.TextViewChecBox;
        String CheckBox = binding.TextViewChecBox.getText().toString();
        binding.BtnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        binding.BtnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActiity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.weatherwise.RegisterActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherwise.LoginActivity.LoginActivity;
import com.example.weatherwise.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActiity extends AppCompatActivity {

    com.example.weatherwise.databinding.ActivityRegisterActiityBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.weatherwise.databinding.ActivityRegisterActiityBinding binding = com.example.weatherwise.databinding.ActivityRegisterActiityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.BtnRegister.getText();
        binding.EditTextSurnName.getText();
        binding.EditTextEmail.getText();
        binding.EditTextPsw.getText();
        binding.EditTextReturnPsw.getText();
        binding.EditTextCity.getText();
        binding.EdiTextCountryCode.getText();
        binding.BtnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActiity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextSurnName = binding.EditTextSurnName;
                String SurnName = binding.EditTextSurnName.getText().toString();
                EditText EditTextEmail = binding.EditTextEmail;
                String Email = binding.EditTextEmail.getText().toString();
                EditText EditTextPsw = binding.EditTextPsw;
                String Psw = binding.EditTextPsw.getText().toString();
                EditText EditTextReturnPsw = binding.EditTextReturnPsw;
                String ReturnPsw = binding.EditTextReturnPsw.getText().toString();
                EditText EditTextCity = binding.EditTextCity;
                String City = binding.EditTextCity.getText().toString();
                EditText EditTextCountryCode = binding.EdiTextCountryCode;
                String CountryCode = binding.EdiTextCountryCode.getText().toString();
                Intent intent = new Intent(RegisterActiity.this, LoginActivity.class);
                startActivity(intent);
                if (TextUtils.isEmpty(SurnName)) {
                    Toast.makeText(RegisterActiity.this, "Введіть Ім'я та Прізвище", Toast.LENGTH_SHORT).show();
                    EditTextSurnName.setError("Неправільні дані у полі Ім'я та Прізвище");
                    EditTextSurnName.requestFocus();
                    if (TextUtils.isEmpty(Email)) {
                        Toast.makeText(RegisterActiity.this, "Введіть E-mail", Toast.LENGTH_SHORT).show();
                        EditTextEmail.setError("Неправільні дані у полі E-mail");
                        EditTextEmail.requestFocus();
                        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                            Toast.makeText(RegisterActiity.this, "Введіть E-mail", Toast.LENGTH_SHORT).show();
                            EditTextEmail.setError("Неправільні дані у полі E-mail");
                            EditTextEmail.requestFocus();
                            if (TextUtils.isEmpty(Psw)) {
                                Toast.makeText(RegisterActiity.this, "Введіть Пароль", Toast.LENGTH_SHORT).show();
                                EditTextEmail.setError("Неправільні дані у полі Пароль");
                                EditTextEmail.requestFocus();
                                if (Psw.length() < 5 ) {
                                    Toast.makeText(RegisterActiity.this, "Пароль повинен містит від 5 символів", Toast.LENGTH_SHORT).show();
                                    EditTextPsw.setError("Надто слабкий пароль");
                                    EditTextPsw.requestFocus();
                                    if (TextUtils.isEmpty(ReturnPsw)) {
                                        Toast.makeText(RegisterActiity.this, "Ввеіть повторно пароль", Toast.LENGTH_SHORT).show();
                                        EditTextReturnPsw.setError("Неправільні дані у полі пароль");
                                        EditTextReturnPsw.requestFocus();
                                        if (ReturnPsw.length() < 5) {
                                            Toast.makeText(RegisterActiity.this, "Пароль повинен містит від 5 символів", Toast.LENGTH_SHORT).show();
                                            EditTextReturnPsw.setError("Неправільні дані у полі пароль");
                                            EditTextReturnPsw.requestFocus();
                                            if (TextUtils.isEmpty(City)) {
                                                Toast.makeText(RegisterActiity.this, "Введіть Місто", Toast.LENGTH_SHORT).show();
                                                EditTextCity.setError("Неправільні дані у полі місто");
                                                EditTextCity.requestFocus();
                                                if (TextUtils.isEmpty(CountryCode)) {
                                                    Toast.makeText(RegisterActiity.this, "Введіть Код Країни", Toast.LENGTH_SHORT).show();
                                                    EditTextCountryCode.setError("Неправільні дані у полі Код Країни");
                                                    EditTextCountryCode.requestFocus();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    registerUser(SurnName,Email,Psw,ReturnPsw,City,CountryCode);
                }
            }
        });


    }

    private void registerUser(String surnName, String email, String psw, String returnPsw, String city, String countryCode) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActiity.this, "Register is successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    firebaseUser.sendEmailVerification();
                    Intent intent = new Intent(RegisterActiity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }
}




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


        binding.BtnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActiity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.TextViewRegister.setText("Реєстрація");
        TextView TextViewRegister = binding.TextViewRegister;
        String Register = binding.TextViewRegister.getText().toString();
        binding.TextViewSurnName.setText("Введіть Ім'я та Прізвище");
        TextView TextViewSurnName = binding.TextViewSurnName;
        String SurnName = binding.TextViewSurnName.getText().toString();
        binding.TextViewEmail.setText("Введіть E-mail");
        TextView TextViewEmail = binding.TextViewEmail;
        String Email = binding.TextViewEmail.getText().toString();
        binding.TextViewPsw.setText("Введіть Пароль");
        TextView TextViewPsw = binding.TextViewPsw;
        String Psw = binding.TextViewPsw.getText().toString();
        binding.TextViewReturnPsw.setText("Введіть повторно пароль");
        TextView TextViewReturnPsw = binding.TextViewReturnPsw;
        String ReturnPsw = binding.TextViewReturnPsw.getText().toString();
        binding.TextViewCity.setText("Введіть місто");
        TextView TextViewCity = binding.TextViewCity;
        String City = binding.TextViewCity.getText().toString();
        binding.TextViewCountryCode.setText("Код Країни");
        TextView TextViewCountryCode = binding.TextViewCountryCode;
        String CountryCode = binding.TextViewCountryCode.getText().toString();

        binding.BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.EditTextSurnName.getText();
                EditText EditTextSurnName = binding.EditTextSurnName;
                String SurnName = binding.TextViewSurnName.getText().toString();
                binding.EditTextEmail.getText();
                EditText EditTextEmail = binding.EditTextEmail;
                String Email = binding.EditTextEmail.getText().toString();
                binding.EditTextPsw.getText();
                EditText EditTextPsw = binding.EditTextPsw;
                String Psw = binding.EditTextPsw.getText().toString();
                binding.EditTextReturnPsw.getText();
                EditText EditTextReturnPsw = binding.EditTextReturnPsw;
                String ReturnPsw = binding.EditTextReturnPsw.getText().toString();
                binding.EditTextCity.getText();
                EditText EditTextCity = binding.EditTextCity;
                String City = binding.EditTextCity.getText().toString();
                binding.EdiTextCountryCode.getText();
                EditText EditTextCountryCode = binding.EdiTextCountryCode;
                String CountryCode = binding.EdiTextCountryCode.getText().toString();


                if (TextUtils.isEmpty(SurnName)) {
                    Toast.makeText(RegisterActiity.this, "Введіть Ім'я та Прізвище", Toast.LENGTH_SHORT).show();
                    EditTextSurnName.setError("Неправільні дані у полі Імя та Прізвище");
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
                                EditTextPsw.setError("Неправільні дані у полі Пароль");
                                EditTextPsw.requestFocus();
                                if (Psw.length() < 5 ) {
                                    Toast.makeText(RegisterActiity.this, "Пароль повинен містити від 5 символів", Toast.LENGTH_SHORT).show();
                                    EditTextPsw.setError("Надто слабкий пароль");
                                    EditTextPsw.requestFocus();
                                    if (TextUtils.isEmpty(ReturnPsw)) {
                                        Toast.makeText(RegisterActiity.this, "Введіть Повторно Пароль", Toast.LENGTH_SHORT).show();
                                        EditTextReturnPsw.setError("Неправільні дані у полі Пароль");
                                        EditTextReturnPsw.requestFocus();
                                        if (ReturnPsw.length() < 5 ) {
                                            Toast.makeText(RegisterActiity.this, "Пароль повинен містити від 5 символів", Toast.LENGTH_SHORT).show();
                                            EditTextReturnPsw.setError("Надто слабкий пароль");
                                            EditTextReturnPsw.requestFocus();
                                            if (TextUtils.isEmpty(City)) {
                                                Toast.makeText(RegisterActiity.this, "Введіть Місто", Toast.LENGTH_SHORT).show();
                                                EditTextCity.setError("Неправільні дані у полі Місто");
                                                EditTextCity.requestFocus();
                                                if (TextUtils.isEmpty(CountryCode)) {
                                                    Toast.makeText(RegisterActiity.this, "Введіть Код Країни", Toast.LENGTH_SHORT).show();
                                                    EditTextCountryCode.setError("Неправільні дані у полі код країни");
                                                    EditTextCountryCode.requestFocus();
                                                } else {
                                                    registerUser(SurnName,Psw,ReturnPsw,Email,City,CountryCode);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    private void registerUser(String surnName, String psw, String returnPsw, String email, String city, String countryCode) {
        Log.e("TAG","StartOfregisterUser");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())  {
                    Toast.makeText(RegisterActiity.this, "Користувач успішно зареєстрований", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActiity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    firebaseUser.sendEmailVerification();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                } else {
                    String massage = task.getException().getLocalizedMessage();
                    Log.e("TAG",massage);
                }
            }
        });
    }
}
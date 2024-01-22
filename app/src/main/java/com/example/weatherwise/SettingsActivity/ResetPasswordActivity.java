package com.example.weatherwise.SettingsActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherwise.ActivitiesDnipro.ActivityMainDnipro;
import com.example.weatherwise.databinding.ActivityResetPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class ResetPasswordActivity extends AppCompatActivity {
    ActivityResetPasswordBinding binding;
    FirebaseAuth firebaseAuth;
    private static final String TAG="ResetPasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResetPasswordBinding binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BtnBackForgotPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        binding.BtnResetPassword.getText();
        binding.EditTextForgotEmail.getText();
        binding.BtnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextEmail = binding.EditTextForgotEmail;
                String Email = binding.EditTextForgotEmail.getText().toString();
                Intent intent = new Intent(ResetPasswordActivity.this,ActivityMainDnipro.class);
                startActivity(intent);
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(ResetPasswordActivity.this, "Будь ласка введіть ваш зарестрований E-mail", Toast.LENGTH_LONG).show();
                    EditTextEmail.setError("E-mail не дійсний");
                    EditTextEmail.requestFocus();
                    if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                        Toast.makeText(ResetPasswordActivity.this, "Будь ласка введіть ваш зарестрований E-mail", Toast.LENGTH_LONG).show();
                        EditTextEmail.setError("E-mail не дійсний");
                    } else {
                        resetPassword(Email);
                    }
                }
            }
        });
    }

    private void resetPassword(String email) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ResetPasswordActivity.this, "\n" +
                            "Будь ласка, перевірте свою поштову скриньку на наявність посилання для зміни пароля", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ResetPasswordActivity.this, ActivityMainDnipro.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e ) {
                    } catch (Exception e ) {
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(ResetPasswordActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(ResetPasswordActivity.this, "Щось пішло не так", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
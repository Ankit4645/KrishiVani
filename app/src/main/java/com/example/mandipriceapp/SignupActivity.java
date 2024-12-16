package com.example.mandipriceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText editTextFullName, editTextEmail, editTextPassword;
    Button buttonSignup;
    CsvHelper csvHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextFullName = findViewById(R.id.etName);
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        buttonSignup = findViewById(R.id.btnSignup);

        csvHelper = new CsvHelper(this);

        // Signup Button Click
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextFullName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (csvHelper.isEmailRegistered(email)) {
                    Toast.makeText(SignupActivity.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                } else if (csvHelper.writeUser(fullName, email, password)) {
                    Toast.makeText(SignupActivity.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                    finish(); // Close Signup Page
                } else {
                    Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

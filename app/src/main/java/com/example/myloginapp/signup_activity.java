package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup_activity extends AppCompatActivity {
    public static int RESULT = 1000 ;
    TextInputLayout email,pass;
    User newUser;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.inputname);
        pass = findViewById(R.id.inputpass);
        auth = FirebaseAuth.getInstance();
        Button Registerbutton = (Button)findViewById(R.id.buttonSignUp);
        Button loginbutton = (Button)findViewById(R.id.buttonLogin);
        ImageView backimg = (ImageView) findViewById(R.id.imageView13);
        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRegister(view);
            }
        });
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleBack(view);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchActivities(MainActivity.class);
            }

        });
    }
    public void handleBack(View view){
        //Intent intent = new Intent();
        //intent.putExtra("user" , newUser);
        //setResult(RESULT , intent);
        //finish();
        switchActivities(MainActivity.class);
    }
    public void handleRegister(View view) {
        String email = this.email.getEditText().getText().toString();
        String pass = this.pass.getEditText().getText().toString();
        if(email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void switchActivities(Class page) {
        Intent switchActivityIntent = new Intent(this, page);
        startActivity(switchActivityIntent);
    }
}
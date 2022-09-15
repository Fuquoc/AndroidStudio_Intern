package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class signup_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button signinbtn = (Button)findViewById(R.id.buttonSignIn);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities(MainActivity.class);
            }

        });
    }

    private void switchActivities(Class page) {
        Intent switchActivityIntent = new Intent(this, page);
        startActivity(switchActivityIntent);
    }
}
package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        Button signupbtn = (Button)findViewById(R.id.buttonSignUp_Login);
        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = username.getText().toString();
                String pw = password.getText().toString();

                Account acc = new Account();
                Hashtable list = acc.Get();
                if (list.containsKey(un)) {
                    if(list.get(un).equals(pw)){
                        //correct
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        switchActivities(activity_home.class);
                    }
                    else {
                        //incorrect
                        Toast.makeText(MainActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //incorrect
                    Toast.makeText(MainActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        signupbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchActivities(signup_activity.class);
            }
        });
    }
        private void switchActivities(Class page) {
            Intent switchActivityIntent = new Intent(this, page);
            startActivity(switchActivityIntent);
        }
}
package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class signup_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button loginbutton = (Button)findViewById(R.id.buttonLogin);
        ImageView backimg = (ImageView) findViewById(R.id.imageView13);
        Button Registerbutton = (Button)findViewById(R.id.buttonSignUp);

        TextInputLayout Username = (TextInputLayout)findViewById(R.id.inputusername);
        TextInputLayout Pass = (TextInputLayout)findViewById(R.id.inputpass);
        DBHelper DB = new DBHelper(this);

        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Username.getEditText().getText().toString();
                String p = Pass.getEditText().getText().toString();
                if(!u.equals("") && !p.equals("")){
                    //Account.Hash.put(u,p);
                    boolean checkuser = DB.CheckUserName(u);
                    if(checkuser==false){
                        boolean insert = DB.insertData(u,p);
                        if(insert==true){
                            Toast.makeText(signup_activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            switchActivities(MainActivity.class);
                        }else {
                            Toast.makeText(signup_activity.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(signup_activity.this, "username is already exist", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(signup_activity.this, "Field User name or Password is Empty!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchActivities(MainActivity.class);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
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
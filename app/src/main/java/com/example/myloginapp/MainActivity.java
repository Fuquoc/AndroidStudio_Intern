package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";

    private final String DefaultUnameValue = "";
    private String UnameValue;

    private final String DefaultPasswordValue = "";
    private String PasswordValue;

    TextView username;
    TextView password;
    CheckBox checkremember;
    @Override
    public void onPause() {
        super.onPause();
        savePreferences();

    }
    @Override
    public void onResume() {
        super.onResume();
        loadPreferences();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        checkremember = (CheckBox)findViewById(R.id.checkBoxRemember);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        Button signupbtn = (Button)findViewById(R.id.buttonSignUp_Login);
        //admin and admin

        DBHelper DB = new DBHelper(this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = username.getText().toString();
                String pw = password.getText().toString();

                //Account acc = new Account();
                //Hashtable list = acc.Get();
             /*   if (list.containsKey(un)) {
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
            */
                if(un.equals("") || pw.equals("")){
                    Toast.makeText(MainActivity.this, "Field Empty", Toast.LENGTH_SHORT).show();
                }else {
                    boolean checkuserpass = DB.CheckUserName(un,pw);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        if(checkremember.isChecked()){
                            savePreferences();
                        }
                        switchActivities(activity_home.class);
                    }else {
                        Toast.makeText(MainActivity.this, "User name or Password incorrect", Toast.LENGTH_SHORT).show();
                    }
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
    private void savePreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // Edit and commit
        UnameValue = username.getText().toString();
        PasswordValue = password.getText().toString();
        System.out.println("onPause save name: " + UnameValue);
        System.out.println("onPause save password: " + PasswordValue);
        editor.putString(PREF_UNAME, UnameValue);
        editor.putString(PREF_PASSWORD, PasswordValue);
        editor.commit();
    }
    private void loadPreferences() {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        username.setText(UnameValue);
        password.setText(PasswordValue);
        System.out.println("onResume load name: " + UnameValue);
        System.out.println("onResume load password: " + PasswordValue);
    }
}
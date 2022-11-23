package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    private FirebaseAuth auth;
    //ArrayList<User> users= new ArrayList<User>();
    //User newUser, userFinded = null;
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signupbtn = (Button)findViewById(R.id.buttonSignUp_Login);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        //sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //username.setText(sharedPreferences.getString("taikhoan", ""));
        //password.setText(sharedPreferences.getString("matkhau", ""));
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin(v);
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                toRegister(v);
            }
        });
    }
    public void toRegister(View view) {
        Intent switchActivityIntent = new Intent(this, signup_activity.class);
        startActivity(switchActivityIntent);
    }
    public void handleLogin(View view) {
        String email = this.username.getText().toString();
        String pass = this.password.getText().toString();
        if(email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                    //SharedPreferences.Editor editor = sharedPreferences.edit();
                    //editor.putString("taikhoan", email);
                    //editor.putString("matkhau", pass);
                    //editor.commit();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == signup_activity.RESULT && resultCode == RESULT_OK) {
            //newUser = (User) data.getSerializableExtra("user");
            //users.add(newUser);
        //}
    }
}
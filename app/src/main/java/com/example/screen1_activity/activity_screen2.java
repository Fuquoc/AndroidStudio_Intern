package com.example.screen1_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity_screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        TextView masv = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();
        //Bundle bundle = intent.getBundleExtra("MSVBundle");
        //String msv = bundle.getString("MSV");
        String msv = intent.getStringExtra("MSV");

        masv.setText("Mã Sinh Viên " + msv);

    }
}
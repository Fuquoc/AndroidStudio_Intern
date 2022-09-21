package com.example.screen1_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchbtn = (Button)findViewById(R.id.button);
        EditText editTextMSV = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText editTextTEN = (EditText)findViewById(R.id.editTextTextPersonName3);
        EditText editTextSDT = (EditText)findViewById(R.id.editTextTextPersonName2);
        switchbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switchActivities(editTextMSV.getText().toString(),editTextTEN.getText().toString(),Integer.parseInt(editTextSDT.getText().toString()) );
            }
        });
    }
    private void switchActivities(String msv,String hoten,int sodienthoai) {
        Intent switchActivityIntent = new Intent(this, activity_screen2.class);

        SinhVien sinhVien = new SinhVien(msv,hoten,sodienthoai);
        Bundle bundle = new Bundle();
        bundle.putSerializable("sinhvien",sinhVien);
        switchActivityIntent.putExtra("MSVBundle",bundle);
        //switchActivityIntent.putExtra("MSV",msv);
        startActivity(switchActivityIntent);
    }
}
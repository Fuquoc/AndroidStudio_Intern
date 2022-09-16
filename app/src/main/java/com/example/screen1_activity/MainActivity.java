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
        EditText editText = (EditText)findViewById(R.id.editTextTextPersonName);
        switchbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switchActivities(editText.getText().toString());
            }
        });
    }
    private void switchActivities(String msv) {
        Intent switchActivityIntent = new Intent(this, activity_screen2.class);
        //Bundle bundle = new Bundle();
        //bundle.putString("MSV",msv);
        //switchActivityIntent.putExtra("MSVBundle",bundle);
        switchActivityIntent.putExtra("MSV",msv);
        startActivity(switchActivityIntent);
    }
}
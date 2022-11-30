package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Item1 extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DB = new DBHelper(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item1);
        Button save = (Button)findViewById(R.id.buttonSave_item1);
        TextView textView = (TextView)findViewById(R.id.TextView_item1);
        EditText editText = (EditText)findViewById(R.id.editText_item1);

        String text=" ";
        List<String> data = new ArrayList<>();
        //data =DB.getData(0);
        if(data == null)
        {
            textView.setText("EMPTY");
        }
        else
        {
            for (int i=0;i<data.size();i++){
                text = text+data.get(i)+"\n";
            }
            textView.setText(text);
        }



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = editText.getText().toString();
                //DB.insertData(temp,0);
                String text="";
                List<String> data = new ArrayList<>();
                //data =DB.getData(0);
                for (int i=0;i<data.size();i++){
                    text = text+data.get(i)+"\n";
                }
                textView.setText(text);

            }
        });
    }
}
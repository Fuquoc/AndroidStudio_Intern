package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("tomtat");
            int imageid = intent.getIntExtra("imageid",R.drawable.a);

            binding.nameProfile.setText(name);
            binding.tomtat.setText(phone);
            binding.profileImage.setImageResource(imageid);
        }
        DBHelper DB = new DBHelper(this);

        Button btndanhgia = (Button)findViewById(R.id.buttonDanhgia);
        EditText editTextsao = (EditText) findViewById(R.id.edittextsao);

        List<Integer> data = new ArrayList<Integer>();
        data = DB.getData(0);
        int sao = 0;
        if(data == null)
        {
            editTextsao.setText("0 sao");
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                sao += data.get(i);
            }
            editTextsao.setText(sao + " sao");
        }

        btndanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = editTextsao.getText().toString();
                DB.insertData(Integer.parseInt(temp),0);
                List<Integer> data = new ArrayList<>();


                data = DB.getData(0);
                int sao = 0;
                if(data == null)
                {
                    editTextsao.setText("0 sao");
                }
                else
                {
                    for (int i=0;i<data.size();i++){
                        sao += data.get(i);
                    }
                    editTextsao.setText(sao + " sao");
                }
            }
        });
    }
}
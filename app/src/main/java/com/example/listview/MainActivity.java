package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listview1);

        ArrayList<MonHoc> arrayList;

        Adapper adapper;

        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Lap Trinh Di Dong",0,0));
        arrayList.add(new MonHoc("Cong Nghe XML",0,0));

        adapper = new Adapper(MainActivity.this,R.layout.layout_monhoc,arrayList);

        listView.setAdapter(adapper);
    }
}
package com.example.screen1_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class activity_screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        Button switchbtn = (Button)findViewById(R.id.button2);
        TextView masv = (TextView)findViewById(R.id.textView3);
        TextView hoten = (TextView)findViewById(R.id.textView5);
        TextView sdt = (TextView)findViewById(R.id.textView6);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MSVBundle");
        SinhVien sinhVien = (SinhVien) bundle.getSerializable("sinhvien");
        //String msv = intent.getStringExtra("MSV");
        String msv = sinhVien.MaSinhVien;
        String stringhoten = sinhVien.HoTen;
        int sodienthoai = sinhVien.SoDienThoai;
        masv.setText("Mã Sinh Viên " + msv);
        hoten.setText("Họ Tên " + stringhoten);
        sdt.setText("Số Điện Thoại " + sodienthoai);
        switchbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}
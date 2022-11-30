package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        int[] imageId = {R.drawable.hc,R.drawable.qd,R.drawable.xd,R.drawable.xq,R.drawable.th};
        String[] name = {"Huy Cận","Quang Dũng","Xuân Diệu","Xuân Quỳnh","Tố Hữu"};
        String[] mota = {"Cù Huy Cận (1919 – 2005), bút danh hoạt động nghệ thuật là Huy Cận, là một chính khách, từng giữ nhiều chức vụ lãnh đạo cao cấp trong chính phủ Việt Nam ",
                "Quang Dũng (tên khai sinh là Bùi Đình Diệm; sinh 11 tháng 10 năm 1921 – mất 13 tháng 10 năm 1988) là một nhà thơ Việt Nam.",
                "Ngô Xuân Diệu (2 tháng 2 năm 1916 — 18 tháng 12 năm 1985), là nhà thơ, nhà báo, nhà văn viết truyện ngắn và nhà phê bình văn học người Việt Nam.",
                "Xuân Quỳnh (6 tháng 10 năm 1942 – 29 tháng 8 năm 1988), tên đầy đủ là Nguyễn Thị Xuân Quỳnh, là một nữ nhà thơ người Việt Nam. "
                ,"Tố Hữu, tên thật là Nguyễn Kim Thành (4 tháng 10 năm 1920 – 9 tháng 12 năm 2002) quê gốc ở làng Phù Lai, nay thuộc xã Quảng Thọ, huyện Quảng Điền, tỉnh Thừa Thiên Huế, là một nhà thơ tiêu biểu của thơ cách mạng Việt Nam,"};
        String[] sao = {"1890","1890","1890","1890","1890"};
        String[] phoneNo = {"7656610000","9999043232","7834354323","9876543211","5434432343"};
        String[] country = {"United States","Russia","India","Israel","Germany"};

        ArrayList<TacGia> tacGiaArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            TacGia tacGia = new TacGia(name[i],mota[i],sao[i],phoneNo[i],country[i],imageId[i]);
            tacGiaArrayList.add(tacGia);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this, tacGiaArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Intent i = new Intent(MainActivity.this,UserActivity.class);
                //i.putExtra("name",name[position]);
                //i.putExtra("phone",phoneNo[position]);
                //i.putExtra("country",country[position]);
                //i.putExtra("imageid",imageId[position]);
                //startActivity(i);


                //if(position==0){

                    startActivity(new Intent(MainActivity.this, ListSach.class));

                //}else if(position==1){

                    //startActivity(new Intent(MainActivity.this,item3.class));
                //}else{

                //}

            }
        });

    }
}
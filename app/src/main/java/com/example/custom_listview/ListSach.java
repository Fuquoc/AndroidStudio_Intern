package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListSach extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tac_gia);

        int[] imageId = {R.drawable.datnohoa,R.drawable.haibantaye,R.drawable.hatlaigieo};
        String[] name = {"Đất Nở Hoa","Hai Bàn Tay Em","Sergio","Hạt Lại Gieo"};
        String[] lastMessage = {"Tập thơ Đất nở hoa (NXB Văn học, 1960)",
                "Bài thơ hay các bạn vừa xem là bài “Hai Bàn Tay Em” của tác giả Cù Huy Cận. Thuộc danh mục Thơ Huy Cận trong Những Tác Phẩm Thơ Tiêu Biểu Và Nổi Tiếng",
                "Tập thơ Hạt lại gieo (1984)"};
        String[] lastmsgTime = {"0 sao","0 sao","0 sao"};
        String[] TomTat = {"Bên cạnh các tập thơ khác, Huy Cận còn nổi tiếng với nhiều tập thơ hay đặc sắc. Và một trong số đó phải kể tới tập thơ Hạt lại gieo. Đây là một tập thơ được viết năm 1984 và từ đó đã nâng lên thành một sự khái quát. Đó cũng chính là khát khao được hòa vào biển cả mênh mông bao la. Và qua đó ta cảm nhận được chất trí tuệ, cùng với đó là những rung động bằng trái tim thi sĩ. Cùng đọc các vần thơ hay của Huy Cận dưới đây bạn nhé"
                ,"Bên cạnh các tập thơ khác, Huy Cận còn nổi tiếng với nhiều tập thơ hay đặc sắc. Và một trong số đó phải kể tới tập thơ Hạt lại gieo. Đây là một tập thơ được viết năm 1984 và từ đó đã nâng lên thành một sự khái quát. Đó cũng chính là khát khao được hòa vào biển cả mênh mông bao la. Và qua đó ta cảm nhận được chất trí tuệ, cùng với đó là những rung động bằng trái tim thi sĩ. Cùng đọc các vần thơ hay của Huy Cận dưới đây bạn nhé",
                "Bên cạnh các tập thơ khác, Huy Cận còn nổi tiếng với nhiều tập thơ hay đặc sắc. Và một trong số đó phải kể tới tập thơ Hạt lại gieo. Đây là một tập thơ được viết năm 1984 và từ đó đã nâng lên thành một sự khái quát. Đó cũng chính là khát khao được hòa vào biển cả mênh mông bao la. Và qua đó ta cảm nhận được chất trí tuệ, cùng với đó là những rung động bằng trái tim thi sĩ. Cùng đọc các vần thơ hay của Huy Cận dưới đây bạn nhé"};

        ArrayList<TacGia> tacGiaArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            TacGia tacGia = new TacGia(name[i],lastMessage[i],lastmsgTime[i],TomTat[i],"",imageId[i]);
            tacGiaArrayList.add(tacGia);

        }
        listView = (ListView)findViewById(R.id.listtacgia);

        ListAdapter listAdapter = new ListAdapter(ListSach.this, tacGiaArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListSach.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("tomtat",TomTat[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });
    }
}
package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapper extends BaseAdapter {

    public Context context;
    public int layout;
    public List<MonHoc> arraylist;


    public Adapper(Context context,int layout,List<MonHoc> arraylist){
        this.arraylist=arraylist;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        MonHoc monHoc = arraylist.get(i);
        TextView textmh = view.findViewById(R.id.textView_tenmon);
        TextView textd1 = view.findViewById(R.id.textView_diem1);
        TextView textd2 = view.findViewById(R.id.textView_diem2);

        textmh.setText(monHoc.tenMon);
        textd1.setText((int) monHoc.diemGK);
        textd2.setText((int) monHoc.diemCK);

        return null;
    }
}

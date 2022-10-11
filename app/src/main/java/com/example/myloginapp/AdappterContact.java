package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdappterContact extends BaseAdapter {
    private Context context;
    private int layout;
    private List<contact> list;

    public AdappterContact(Context context, int layout, List<contact> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        contact ct = list.get(i);
        TextView textView = view.findViewById(R.id.listview_Name);
        TextView textView1 = view.findViewById(R.id.listview_phone);
        ImageView image = view.findViewById(R.id.listview_image);


        textView.setText(ct.getContactname());
        textView1.setText(ct.getPhone());
        image.setImageResource(ct.getImage());
        return view;
    }
}

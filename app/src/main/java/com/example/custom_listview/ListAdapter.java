package com.example.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<TacGia> {


    public ListAdapter(Context context, ArrayList<TacGia> tacGiaArrayList){

        super(context,R.layout.list_item, tacGiaArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TacGia tacGia = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView name = convertView.findViewById(R.id.personName);
        TextView mota = convertView.findViewById(R.id.lastMessage);
        TextView saohoacnamsinh = convertView.findViewById(R.id.msgtime);

        imageView.setImageResource(tacGia.imageId);
        name.setText(tacGia.name);
        mota.setText(tacGia.mota);
        saohoacnamsinh.setText(tacGia.saohoacnamsinh);


        return convertView;
    }
}

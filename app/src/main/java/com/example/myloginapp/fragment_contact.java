package com.example.myloginapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_contact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_contact.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_contact newInstance(String param1, String param2) {
        fragment_contact fragment = new fragment_contact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        ListView listView = view.findViewById(R.id.listviewContact);
        ArrayList<contact> arrayList;
        AdappterContact adappterContact;

        arrayList = new ArrayList<>();
        arrayList.add(new contact("Phú Quốc","+8477456902",R.drawable.avatar_svgrepo_com__2_));
        arrayList.add(new contact("Anh Quốc","+8432622174",R.drawable.avatar_svgrepo_com__3_));
        arrayList.add(new contact("Trọng Khoa","+8421285589",R.drawable.avatar_svgrepo_com));
        arrayList.add(new contact("Trọng Khoa","+8421285589",R.drawable.avatar_svgrepo_com__4_));
        arrayList.add(new contact("Trọng Khoa","+8421285589",R.drawable.avatar_svgrepo_com__5_));
        arrayList.add(new contact("Trọng Khoa","+8421285589",R.drawable.avatar_svgrepo_com__1_));
        arrayList.add(new contact("Trọng Khoa","+8421285589",R.drawable.avatar_svgrepo_com));

        adappterContact = new AdappterContact(view.getContext(),R.layout.layout_contact,arrayList);
        listView.setAdapter(adappterContact);

        return view;
    }
}
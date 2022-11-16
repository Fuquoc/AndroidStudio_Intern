package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myloginapp.databinding.ActivityHomeBinding;
import com.example.myloginapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_home extends AppCompatActivity {

    Home_Fragment home_fragment = new Home_Fragment();
    fragment_contact fragmentContact = new fragment_contact();
    fragment_profile fragmentProfile = new fragment_profile();
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,home_fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,home_fragment).commit();
                        return  true;
                    case R.id.contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragmentContact).commit();
                        return  true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragmentProfile).commit();
                        return  true;
                }
                return false;
            }
        });
    }
}
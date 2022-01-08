package com.example.booking_hotel_owner.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking_hotel_owner.Capture;
import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.fragment.AddHotel;
import com.example.booking_hotel_owner.fragment.Check_Phong;
import com.example.booking_hotel_owner.fragment.DSXetDuyetThuePhong;
import com.example.booking_hotel_owner.fragment.Profile;
import com.example.booking_hotel_owner.fragment.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.nav_menu);

        home home = new home();

        loadFragment(home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                home home = new home();
                switch (item.getItemId()){
                    case R.id.menu_home:
                        loadFragment(home);
                        return true;

                    case R.id.menu_them:
                        fragment = new DSXetDuyetThuePhong();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_check:
                        fragment = new Profile();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });

    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.continer,fragment);
        fragmentTransaction.commit();
    }

}
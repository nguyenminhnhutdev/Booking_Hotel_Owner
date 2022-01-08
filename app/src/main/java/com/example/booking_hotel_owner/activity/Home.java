package com.example.booking_hotel_owner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.fragment.AddHotel;
import com.example.booking_hotel_owner.fragment.Check_Phong;
import com.example.booking_hotel_owner.fragment.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        home home = new home();

        loadFragment(home);

        bottomNavigationView = findViewById(R.id.nav_menu);

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
                        fragment = new AddHotel();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_check:
                        fragment = new Check_Phong();
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
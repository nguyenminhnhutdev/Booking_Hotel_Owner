package com.example.booking_hotel_owner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.booking_hotel_owner.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
    }
}
package com.example.booking_hotel_owner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.booking_hotel_owner.R;

public class AcceptChecking extends AppCompatActivity {
EditText txt_idbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_checking);
        txt_idbook=findViewById(R.id.txt_idbook);
        load();
    }
    private  void load()
    {
        Intent intent= getIntent();
        txt_idbook.setText(intent.getStringExtra("id"));
    }
}
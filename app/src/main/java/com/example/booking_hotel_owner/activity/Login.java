package com.example.booking_hotel_owner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking_hotel_owner.R;

public class Login extends AppCompatActivity {

    TextView btn_login,txt_form_dangnhap,txt_form_dangky;
    RelativeLayout form_dangnhap, form_dangky;
    LinearLayout acti_dangnhap, acti_dangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        form_dangnhap = findViewById(R.id.relativeLayout_dn);
        form_dangky = findViewById(R.id.relativeLayout_dk);
        acti_dangnhap = findViewById(R.id.line_login);
        acti_dangky = findViewById(R.id.line_dangky);
        txt_form_dangnhap = findViewById(R.id.txt_form_dangnhap);
        txt_form_dangky = findViewById(R.id.txt_form_dangky);


        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }
        });

        txt_form_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form_dangnhap.setVisibility(View.VISIBLE);
                form_dangky.setVisibility(View.INVISIBLE);
                acti_dangky.setVisibility(View.INVISIBLE);
                acti_dangnhap.setVisibility(View.VISIBLE);
                btn_login.setText("Đăng nhập");

                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }
                });
            }
        });

        txt_form_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form_dangky.setVisibility(View.VISIBLE);
                form_dangnhap.setVisibility(View.INVISIBLE);
                acti_dangky.setVisibility(View.VISIBLE);
                acti_dangnhap.setVisibility(View.INVISIBLE);
                btn_login.setText("Đăng ký");

                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Login.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
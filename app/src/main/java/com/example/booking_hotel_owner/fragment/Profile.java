package com.example.booking_hotel_owner.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.activity.DoiMatKhau;
import com.example.booking_hotel_owner.activity.ThongTinCaNhan;


public class Profile extends Fragment {


    TextView btn_logout,btn_thongtincanhan, btn_doimk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);


        btn_logout = (TextView) view.findViewById(R.id.btn_logout);
        btn_thongtincanhan = (TextView) view.findViewById(R.id.btn_thongtincanhan);
        btn_doimk = (TextView) view.findViewById(R.id.btn_doimk);

        btn_doimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DoiMatKhau.class);
                startActivity(intent);
            }
        });

        btn_thongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ThongTinCaNhan.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }


}
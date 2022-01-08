package com.example.booking_hotel_owner.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking_hotel_owner.Capture;
import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.Scan;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class Check_Phong extends Fragment {
ImageView Scan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check__phong, container, false);
Scan=view.findViewById(R.id.Scan);
Scan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent intent=new Intent(getActivity(), com.example.booking_hotel_owner.Scan.class);
startActivity(intent);
    }
});
        return view;
    }

}
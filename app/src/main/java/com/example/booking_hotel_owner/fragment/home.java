package com.example.booking_hotel_owner.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking_hotel_owner.Model.Room;
import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.Recyclerview_noibat;
import com.example.booking_hotel_owner.Remote.ApiUtils;
import com.example.booking_hotel_owner.Remote.Method;
import com.example.booking_hotel_owner.activity.ThemKhachSanPhong;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home extends Fragment {
RecyclerView rcv_hotel;
    ArrayList<Room> list;
    ImageView btn_add;
    Method method;
    Recyclerview_noibat recyclerview_noibat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_add = (ImageView) view.findViewById(R.id.btn_add);
        rcv_hotel=view.findViewById(R.id.rcv_hotel);
        getRoom();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ThemKhachSanPhong.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private void getRoom () {
        method = ApiUtils.getSOService();
        list = new ArrayList<>();
        method.getRoom().enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                list = (ArrayList<Room>) response.body();
                rcv_hotel .setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
                recyclerview_noibat = new Recyclerview_noibat(getContext(), list);
                rcv_hotel.setLayoutManager(layoutManager);

                rcv_hotel.setAdapter(recyclerview_noibat);
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {

            }
        });
    }
}
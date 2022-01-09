package com.example.booking_hotel_owner.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.booking_hotel_owner.ChecKingActi;
import com.example.booking_hotel_owner.Model.BookingModel;
import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.Recyclerview_booking;
import com.example.booking_hotel_owner.Remote.ApiUtils;
import com.example.booking_hotel_owner.Remote.Method;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DSXetDuyetThuePhong extends Fragment {


RecyclerView rcv_xetduyet;
    ArrayList<BookingModel> list;
    ImageView nextChecking;
    ImageView img_checking;
    Method method;
    EditText editText;
    Recyclerview_booking recyclerview_booking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_d_s_xet_duyet_thue_phong, container, false);
      rcv_xetduyet=view.findViewById(R.id.rcv_xetduyet);
        nextChecking=view.findViewById(R.id.nextChecking);
        nextChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext().getApplicationContext(),ChecKingActi.class);
                startActivity(intent);
            }
        });

        getbook();
        return view;
    }
    private void getbook () {
        method = ApiUtils.getSOService();
        list = new ArrayList<>();
        method.getbook().enqueue(new Callback<List<BookingModel>>() {
            @Override
            public void onResponse(Call<List<BookingModel>> call, Response<List<BookingModel>> response) {
                list = (ArrayList<BookingModel>) response.body();
                rcv_xetduyet .setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerview_booking = new Recyclerview_booking (getContext(),list );
                rcv_xetduyet.setLayoutManager(layoutManager);

                rcv_xetduyet.setAdapter(recyclerview_booking);
            }

            @Override
            public void onFailure(Call<List<BookingModel>> call, Throwable t) {

            }
        });
    }
}
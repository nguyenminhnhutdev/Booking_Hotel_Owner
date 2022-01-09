package com.example.booking_hotel_owner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking_hotel_owner.Model.BookingModel;
import com.example.booking_hotel_owner.Model.Room;
import com.example.booking_hotel_owner.Remote.ApiUtils;
import com.example.booking_hotel_owner.Remote.Method;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChecKingActi extends AppCompatActivity {
RecyclerView checking;
    ArrayList<BookingModel> list;
    ImageView btn_add;
    ImageView img_checking;
    Method method;
    EditText editText;
    Recyclerview_booking recyclerview_booking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chec_king);
        checking=findViewById(R.id.checking);
        img_checking=findViewById(R.id.img_checking);
        editText=findViewById(R.id.txt_checkin1);
        img_checking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator= new IntentIntegrator(ChecKingActi.this);
                intentIntegrator.setPrompt("Check Booking");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                recyclerview_booking.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        getbook();
    }
    private void getbook () {
        method = ApiUtils.getSOService();
        list = new ArrayList<>();
        method.getbook().enqueue(new Callback<List<BookingModel>>() {
            @Override
            public void onResponse(Call<List<BookingModel>> call, Response<List<BookingModel>> response) {
                list = (ArrayList<BookingModel>) response.body();
                checking .setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ChecKingActi.this);
                recyclerview_booking = new Recyclerview_booking (ChecKingActi.this,list );
                checking.setLayoutManager(layoutManager);

                checking.setAdapter(recyclerview_booking);
            }

            @Override
            public void onFailure(Call<List<BookingModel>> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult.getContents()!=null)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(ChecKingActi.this);
            builder.setMessage(intentResult.getContents());
            editText.setText(intentResult.getContents());
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();

                }
            });
            builder.show();
        }else {
            Toast.makeText(ChecKingActi.this, "k thjeer scan", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.booking_hotel_owner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking_hotel_owner.ChecKingActi;
import com.example.booking_hotel_owner.Model.Hotel;
import com.example.booking_hotel_owner.Model.PostHotelModel;
import com.example.booking_hotel_owner.Model.Room;
import com.example.booking_hotel_owner.Model.StatusModel;
import com.example.booking_hotel_owner.Model.UserModel;
import com.example.booking_hotel_owner.R;
import com.example.booking_hotel_owner.Remote.ApiUtils;
import com.example.booking_hotel_owner.Remote.Method;
import com.example.booking_hotel_owner.ResultModel.PostHotel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView btn_login,txt_form_dangnhap,txt_form_dangky;
    RelativeLayout form_dangnhap, form_dangky;
    LinearLayout acti_dangnhap, acti_dangky;
    TextInputEditText txt_taikhoan, txt_matkhau;
    TextInputEditText txt_taikhoan1, txt_matkhau1, txt_nameHotel,txt_matkhau2, txt_email2, txt_idHotel;
    private Method method;
    public static  Hotel hotel;
    public static  String idUser;
    ArrayList<Room> listRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        method = ApiUtils.getSOService();

        form_dangnhap = findViewById(R.id.relativeLayout_dn);
        form_dangky = findViewById(R.id.relativeLayout_dk);
        acti_dangnhap = findViewById(R.id.line_login);
        acti_dangky = findViewById(R.id.line_dangky);
        txt_form_dangnhap = findViewById(R.id.txt_form_dangnhap);
        txt_form_dangky = findViewById(R.id.txt_form_dangky);
        txt_taikhoan = findViewById( R.id.txt_taikhoan);
        txt_matkhau = findViewById(R.id.txt_matkhau);



        txt_taikhoan1 = findViewById(R.id.txt_taikhoan1);
        txt_nameHotel = findViewById(R.id.txt_nameHotel);
        txt_matkhau2 = findViewById(R.id.txt_matkhau2);
        txt_email2= findViewById(R.id.txt_email2);
        txt_idHotel = findViewById(R.id.txt_id_hotel);

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingInUser();



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

                        SingInUser();
                        /*Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);*/
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
                        SingUpUser();
                    }
                });
            }
        });
    }


    private void SingInUser() {
        String username = txt_taikhoan.getEditableText().toString().trim();
        String password = txt_matkhau.getEditableText().toString().trim();
        listRoom = new ArrayList<>();
        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(Login.this, "Vui lòng điền thông tin để đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        method.getUserLogin(username, password).enqueue(new Callback<StatusModel>() {
            @Override
            public void onResponse(Call<StatusModel> call, Response<StatusModel> response) {
                if (response.body().getStatusCode() == true) {
                    UserModel user = response.body().getUsers();
                    if(user.getIsCustomerOwner().equals("1")){
                        Toast.makeText(Login.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Log.v("idUser", response.body().getUsers().getIduser());
                        idUser = response.body().getUsers().getIduser();
                       Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(Login.this, "Vui lòng kiểm tra lại thông tin đăng nhập!", Toast.LENGTH_SHORT).show();
                }
                Log.v("status", "ok");
            }

            @Override
            public void onFailure(Call<StatusModel> call, Throwable t) {
                Toast.makeText(Login.this, "Mất kết nối máy chủ!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void SingUpUser() {


        String usernameSingUp = txt_taikhoan1.getEditableText().toString();
        String passwordSingUp = txt_nameHotel.getEditableText().toString();
        String emailSingUp = txt_matkhau2.getEditableText().toString();
        String fullNameSingUp = txt_email2.getEditableText().toString();
        String idHotel = txt_idHotel.getEditableText().toString();



        method.postHotel(usernameSingUp, emailSingUp, idHotel, passwordSingUp, fullNameSingUp).enqueue(new Callback<PostHotel>() {
            @Override
            public void onResponse(Call<PostHotel> call, Response<PostHotel> response) {
                Log.v("statussss",response.body().getStatusCode().toString());
                if(response.body().getStatusCode()==true){
                    Toast.makeText(Login.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, Login.class));
                }
                else {
                    Toast.makeText(Login.this, "Tên đăng nhập trùng! Vui lòng thử lại!!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostHotel> call, Throwable t) {

            }
        });

    }


}
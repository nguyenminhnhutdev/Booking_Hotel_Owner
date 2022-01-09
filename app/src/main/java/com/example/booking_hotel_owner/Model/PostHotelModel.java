package com.example.booking_hotel_owner.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PostHotelModel implements Serializable {


   /* public PostHotelModel(String hotelId, String nameHotel, String phone, String username, String password) {
        this.hotelId = hotelId;
        this.nameHotel = nameHotel;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }*/

    @SerializedName("hotelId")
    @Expose
    private String hotelId;
    @SerializedName("nameHotel")
    @Expose
    private String nameHotel;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
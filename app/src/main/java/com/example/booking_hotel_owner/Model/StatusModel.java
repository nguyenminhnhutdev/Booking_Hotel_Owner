package com.example.booking_hotel_owner.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StatusModel {

    @SerializedName("statusCode")
    @Expose
    private Boolean statusCode;
    @SerializedName("users")
    @Expose
    private UserModel users;
    public UserModel getUsers() {
        return users;
    }

    public void setUsers(UserModel users) {
        this.users = users;
    }

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

}
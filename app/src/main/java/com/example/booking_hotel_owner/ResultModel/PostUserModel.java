package com.example.booking_hotel_owner.ResultModel;


import com.example.booking_hotel_owner.Model.CustomerModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostUserModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customer")
    @Expose
    private CustomerModel customer;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

}
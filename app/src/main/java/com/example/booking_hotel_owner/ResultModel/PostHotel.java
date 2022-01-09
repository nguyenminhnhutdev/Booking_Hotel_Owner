package com.example.booking_hotel_owner.ResultModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostHotel {

    @SerializedName("statusCode")
    @Expose
    private Boolean statusCode;
    @SerializedName("id")
    @Expose
    private String id;

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


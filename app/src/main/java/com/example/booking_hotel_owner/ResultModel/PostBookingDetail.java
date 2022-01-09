package com.example.booking_hotel_owner.ResultModel;



import com.example.booking_hotel_owner.Model.BookingDetailModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostBookingDetail {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("bookingDetail")
    @Expose
    private BookingDetailModel bookingDetail;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingDetailModel getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetailModel bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

}
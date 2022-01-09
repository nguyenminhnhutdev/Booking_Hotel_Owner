package com.example.booking_hotel_owner.ResultModel;




import com.example.booking_hotel_owner.Model.FeedBackModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GetFeedBackByHotel {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("tb")
    @Expose
    private Double tb;
    @SerializedName("list")
    @Expose
    private List<FeedBackModel> list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTb() {
        return tb;
    }

    public void setTb(Double tb) {
        this.tb = tb;
    }

    public List<FeedBackModel> getList() {
        return list;
    }

    public void setList(List<FeedBackModel> list) {
        this.list = list;
    }

}
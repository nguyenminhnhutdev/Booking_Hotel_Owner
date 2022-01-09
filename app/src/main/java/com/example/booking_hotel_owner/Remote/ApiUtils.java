package com.example.booking_hotel_owner.Remote;

public class ApiUtils {
    public static final String BASE_URL ="https://bookinghotelapi.azurewebsites.net/";//Tien ich cua retrofit 2 giup tao utl co so

    public static Method getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(Method.class);
    }
}

package com.example.booking_hotel_owner.Remote;



import com.example.booking_hotel_owner.Model.BookingDetailModel;
import com.example.booking_hotel_owner.Model.BookingModel;
import com.example.booking_hotel_owner.Model.CustomerModel;
import com.example.booking_hotel_owner.Model.FeedBackModel;
import com.example.booking_hotel_owner.Model.Hotel;
import com.example.booking_hotel_owner.Model.PostFeedBackModel;
import com.example.booking_hotel_owner.Model.PostHotelModel;
import com.example.booking_hotel_owner.Model.Room;
import com.example.booking_hotel_owner.Model.Room1;
import com.example.booking_hotel_owner.Model.StatusModel;
import com.example.booking_hotel_owner.Model.UserModelPost;
import com.example.booking_hotel_owner.ResultModel.GetFeedBackByHotel;
import com.example.booking_hotel_owner.ResultModel.PostBooking;
import com.example.booking_hotel_owner.ResultModel.PostBookingDetail;
import com.example.booking_hotel_owner.ResultModel.PostCustomer;
import com.example.booking_hotel_owner.ResultModel.PostHotel;
import com.example.booking_hotel_owner.ResultModel.PostUserModel;
import com.example.booking_hotel_owner.ResultModel.ResultModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Method {
    @GET("api/User/get-user")
    Call<StatusModel> getUserLogin(@Query("username") String username, @Query("pass") String pass);

    @POST("api/User/insert-user")
    Call<PostUserModel> InsertUser(@Body UserModelPost userModelPost);

    @POST("/api/Booking/insert-booking")
    Call<PostBooking> InsertBooking(@Body BookingModel bookingModel);
    @POST("/api/FeedBack")
    Call<PostFeedBackModel> InsertFeedback(@Body PostFeedBackModel feekBackModel);

    @POST ("api/Customer/insert-customergoogle")
    Call<PostCustomer> InsertCustomer (@Body CustomerModel customerModel);

    @GET ("api/Customer/{id}")
    Call<CustomerModel> GetCustomer (@Path("id") String id);

    @GET ("api/Customer/get-iduser")
    Call<CustomerModel> GetCustomerByIdUser (@Query("id") String id);

    @POST ("api/Booking/insert-bookingdetail")
    Call <PostBookingDetail> PostBookingDetail(@Query("dateStart") String dateStart, @Query("dateEnd") String dateEnd, @Query("idBooking") String idBooking,
                                               @Query("idroom") String idroom);

    @GET ("api/FeedBack/get-sumAssess")
    Call <GetFeedBackByHotel> GetFeedBackByHotel(@Query("idHotel") String idHotel);

    @GET ("api/FeedBack/get-hotel")
    Call <List<FeedBackModel>> GetFeedBack(@Query("idHotel") String idHotel);

    @GET("api/Room")
    Call<List<Room>> getRoom();
    @GET("api/Booking")
    Call<List<BookingModel>> getbook();

    /*@GET("api/Booking/get-customer")
    Call<HistoryBooking> GetHistoryBooking(@Query("idCustomer") String idCustomer);*/

    @GET("api/Booking/get-customer")
    Call<List<BookingModel>> GetHistoryBooking(@Query("idCustomer") String idCustomer);

    @GET("/api/BookingDetail/get-idbooking")
    Call<BookingDetailModel> GetBookingDetail(@Query("idBooking") String idBooking);

    @GET("api/Hotel/{idHotel}")
    Call<Hotel> getHotel (@Path("idHotel") String idHotel);



    //////////////////////////////////////////////////////////////////
    @GET ("api/Hotel/get-hotelbyiduser")
    Call<Hotel> getHotelByIdUser (@Query("idUser") String idUser);

    @POST("/User/post-userhotel")
    Call<PostHotel> postHotel (@Query("username") String username,
                               @Query("pass")String pass,
                               @Query("idhotel")String idhotel,
                               @Query("namehotel")String namehotel,
                               @Query("phone")String phone);
    @PUT("api/Booking/update-booking")
    Call<ResultModel> updateBooking(@Query("idBooking")String idBooking);



}

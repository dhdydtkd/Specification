package com.example.specification.config.retrofit;


import retrofit2.Call;
import retrofit2.http.*;

public interface RestInterface {

    // 반환 타입은 Call<타입>의 제네릭 형태
    @GET("directions")
    Call<Object> getWayDirections(
            @Header("Authorization") String token,
            @Header("Content-Type") String content,
            @Query("origin") String origin,
            @Query("destination") String destination
    );

    @POST("fcm")
    Call<Object> sendFCM(
            @Header("Authorization") String token,
            @Header("Content-Type") String content,
            @Field("body") String body
    );

}

package com.example.specification.config.retrofit;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    private static String API_URL = "http://localhost:8080/";

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(API_URL)
                //.addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Bean
    public RestInterface serverAPIs(Retrofit retrofit) {
        return retrofit.create(RestInterface.class);
    }

}
package com.example.ejemplonav;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient cliente = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://andresvportfolio.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

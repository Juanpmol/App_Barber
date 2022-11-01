package com.example.ejemplonav.interfaces;

import com.example.ejemplonav.model.Auth;
import com.example.ejemplonav.model.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthService {
    @POST("auth/")
    Call<AuthResponse> setAuth(@Body Auth auth);
}

package com.example.mantenimiento;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("nombreU") String nombreU,
            @Field("password") String password
    );

}

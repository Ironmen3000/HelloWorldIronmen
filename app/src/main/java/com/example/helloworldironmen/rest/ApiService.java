package com.example.helloworldironmen.rest;

import com.example.helloworldironmen.model.RootBatikModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("batik/all")
    Call<RootBatikModel> getData();
}

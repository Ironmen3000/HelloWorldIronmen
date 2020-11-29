package com.example.helloworldironmen.rest;

import com.example.helloworldironmen.model.RootHotelModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("purwakarta/hotel")
    Call<RootHotelModel> getData();
}

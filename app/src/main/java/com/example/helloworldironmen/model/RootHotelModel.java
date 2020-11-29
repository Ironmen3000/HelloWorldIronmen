package com.example.helloworldironmen.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootHotelModel{

    @SerializedName("hotel")
    private List<HotelItem> hotel;

    public void setHotel(List<HotelItem> hotel){
        this.hotel = hotel;
    }

    public List<HotelItem> getHotel(){
        return hotel;
    }
}
package com.example.helloworldironmen.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootBatikModel{

    @SerializedName("max_price")
    private Integer maxPrice;

    @SerializedName("min_price")
    private Integer minPrice;

    @SerializedName("total_halaman")
    private Integer totalHalaman;

    @SerializedName("hasil")
    private List<HasilItem> hasil;

    @SerializedName("total_element")
    private Integer totalElement;

    public void setMaxPrice(Integer maxPrice){
        this.maxPrice = maxPrice;
    }

    public Integer getMaxPrice(){
        return maxPrice;
    }

    public void setMinPrice(Integer minPrice){
        this.minPrice = minPrice;
    }

    public Integer getMinPrice(){
        return minPrice;
    }

    public void setTotalHalaman(Integer totalHalaman){
        this.totalHalaman = totalHalaman;
    }

    public Integer getTotalHalaman(){
        return totalHalaman;
    }

    public void setHasil(List<HasilItem> hasil){
        this.hasil = hasil;
    }

    public List<HasilItem> getHasil(){
        return hasil;
    }

    public void setTotalElement(Integer totalElement){
        this.totalElement = totalElement;
    }

    public Integer getTotalElement(){
        return totalElement;
    }
}
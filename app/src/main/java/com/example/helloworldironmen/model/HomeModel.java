package com.example.helloworldironmen.model;

public class HomeModel {
    private String name;
    private int quantity;
    private String img;

    public HomeModel(String name, int quantity, String img) {
        this.name = name;
        this.quantity = quantity;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}



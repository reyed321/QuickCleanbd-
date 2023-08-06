package com.example.quickcleanbd.Model;

public class RecommendedModel {

    private int imageResId;
    private String name;
    private String price;
    private String distance;

    public RecommendedModel(int imageResId, String name, String price, String distance) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
        this.distance = distance;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}



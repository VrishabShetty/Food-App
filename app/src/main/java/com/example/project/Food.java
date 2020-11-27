package com.example.project;

import android.media.Image;
import android.widget.ImageView;

import java.util.UUID;

public class Food {

    private String name;
    private Integer image;
    private String des;
    private float price;
    private float rating;
    private UUID id;
    private boolean isInCart;

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }

    public Food() {
        id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

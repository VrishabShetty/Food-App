package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Foods {

    private static Foods sFoods;
    private List<Food> mFoods;
    private List<Food>Cart;

    private Foods() {

        mFoods = new ArrayList<>();


            Food food = new Food();
            food.setInCart(false);
            food.setGood(false);
            food.setImage(R.drawable.pizza);
            food.setName("Pizza");
            food.setDes("Food is Good");
            // Setting Price and rating
            food.setPrice(400.00f);
            food.setRating(2.0f);
            //
            mFoods.add(food);


            food = new Food();
            food.setInCart(false);
            food.setGood(false);
            food.setImage(R.drawable.pizza);
            food.setName("Pizza1");
            food.setDes("Food is Good");
            food.setPrice(800.00f);
            food.setRating(4.0f);
            mFoods.add(food);

            food = new Food();
            food.setInCart(false);
            food.setGood(false);
            food.setImage(R.drawable.pizza1);
            food.setName("Pizza2");
            food.setDes("Food is Good");
            food.setPrice(600.00f);
            food.setRating(3.0f);
            mFoods.add(food);

    }

    public Food getFood(UUID id) {

        for(Food f : mFoods) {
            if(f.getId().equals(id)) return f;
        }

        return null;
    }

    public List<Food> getFoods() {
        return mFoods;
    }

    public void add (Food food){
        if(Cart == null) Cart = new ArrayList<>();

        Cart.add(food);
    }

    public List<Food> getCart() { return Cart; }

    public static Foods get() {
        if(sFoods == null) {
            sFoods = new Foods();
        }

        return sFoods;
    }
}

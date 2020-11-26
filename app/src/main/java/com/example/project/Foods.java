package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Foods {

    private static Foods sFoods;
    private List<Food> mFoods;

    private Foods() {

        mFoods = new ArrayList<>();

        for(int i=1; i<=100; i++) {
            Food food = new Food();
            if(i==1) {food.setImage(R.drawable.pizza);}
            if(i==10){food.setImage(R.drawable.pizza1);}
            food.setName("Food "+i);
            food.setDes("Food "+i);
            mFoods.add(food);
        }

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

    public static Foods get() {
        if(sFoods == null) {
            sFoods = new Foods();
        }

        return sFoods;
    }
}

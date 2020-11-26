package com.example.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurants {

    private  static Restaurants sRestaurants;
    private List<Restaurant> mRestaurants;

    private Restaurants()
    {
        mRestaurants = new ArrayList<>();

        for(int i=1; i<=20; i++)
        {
            Restaurant r = new Restaurant();
            r.setName("Restaurant "+i);
            mRestaurants.add(r);
        }
    }

    public static Restaurants get()
    {
        if(sRestaurants == null)
        {
            sRestaurants = new Restaurants();
        }

        return sRestaurants;
    }
    public List<Restaurant> getRestaurants()
    {
        return mRestaurants;
    }

    public Restaurant getRestaurant(UUID id)
    {
            for(Restaurant r : mRestaurants)
            {
                if(r.getId().equals(id)) return r;
            }

            return null;
    }

}

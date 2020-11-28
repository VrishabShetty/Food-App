package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurants {

    private  static Restaurants sRestaurants;
    private List<Restaurant> mRestaurants;

    private Restaurants()
    {
        mRestaurants = new ArrayList<>();


            Restaurant r = new Restaurant();
            r.setUrl("http://www.google.com");
            r.setName("Pizza Hut");
            mRestaurants.add(r);

            r = new Restaurant();
            r.setUrl("http://www.google.com");
            r.setName("Pizza Hut");
            mRestaurants.add(r);

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

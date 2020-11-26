package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mRestaurantRecyclerView;
    private RestaurantAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        mRestaurantRecyclerView = view.findViewById(R.id.restaurant_list);
        mRestaurantRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private class RestaurantHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        public RestaurantHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_restaurant,parent,false));

            name = itemView.findViewById(R.id.restaurant_name);
        }

        public void bind (Restaurant restaurant) {
            name.setText(restaurant.getName());
        }
    }

    private class RestaurantAdapter extends RecyclerView.Adapter<RestaurantHolder>
    {
        private List<Restaurant> mRestaurants;

        RestaurantAdapter(List<Restaurant> Restaurants)
        {
            mRestaurants = Restaurants;
        }

        @Override
        public RestaurantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RestaurantHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(RestaurantHolder holder, int position) {
            holder.bind(mRestaurants.get(position));
            MyAnimator.animation(getActivity(),holder.itemView,200);

        }

        @Override
        public int getItemCount() {
            return mRestaurants.size();
        }

    }

    private void updateUI()
    {
        if(mAdapter == null)
        {
            Restaurants restaurants = Restaurants.get();
            List<Restaurant> r = restaurants.getRestaurants();

            mAdapter = new RestaurantAdapter(r);
            mRestaurantRecyclerView.setAdapter(mAdapter);
        }
    }
}

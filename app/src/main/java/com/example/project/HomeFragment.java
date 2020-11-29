package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mRestaurantRecyclerView;
    private RestaurantAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        mRestaurantRecyclerView = view.findViewById(R.id.restaurant_list);
        mRestaurantRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SliderView sliderView = view.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapterExample(getActivity()));

        CardView cardView = view.findViewById(R.id.card_view);

        MyAnimator.animation(getActivity(),cardView,0);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4);
        sliderView.startAutoCycle();

        updateUI();
        return view;
    }

    private class RestaurantHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView name;
        private Restaurant mRestaurant;
        public RestaurantHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_restaurant,parent,false));

            name = itemView.findViewById(R.id.restaurant_name);
        }

        public void bind (Restaurant restaurant) {
            mRestaurant = restaurant;
            name.setText(restaurant.getName());
        }
        @Override
        public void onClick(View v) {
            if(mRestaurant.getUrl() != null) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mRestaurant.getUrl()));
                startActivity(intent);
            }
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
            holder.itemView.setOnClickListener(holder);
            MyAnimator.animation(getActivity(),holder.itemView,200);
        }

        @Override
        public int getItemCount() {
            return mRestaurants.size();
        }

    }
    public class SliderAdapterExample extends
            SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

        private Context context;
        private List<Food> mSliderItems;

        public SliderAdapterExample(Context context) {
            mSliderItems = Foods.get().getTopFood();
            this.context = context;
        }

        @Override
        public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_image, null);
            return new SliderAdapterVH(inflate);
        }

        @Override
        public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

            Food sliderItem = mSliderItems.get(position);

            viewHolder.textViewDescription.setText(sliderItem.getName());
            viewHolder.imageViewBackground.setImageResource(sliderItem.getImage());


            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = FoodActivity.newIntent(getActivity(), sliderItem.getId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getCount() {
            return mSliderItems.size();
        }

        class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

            View itemView;
            ImageView imageViewBackground;
            TextView textViewDescription;

            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
                textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
                this.itemView = itemView;
            }
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

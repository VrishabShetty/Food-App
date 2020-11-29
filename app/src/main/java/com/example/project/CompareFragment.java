package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CompareFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CartAdapter mAdapter;
    private static List<Food> foods;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_compare,container,false);
        mRecyclerView = view.findViewById(R.id.list_compare);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private class CartHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameFood;
        private ImageButton delete;
        private TextView price;
        private ImageView good;
        private Food mFood;

        public CartHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_cart,parent,false));
            mNameFood = itemView.findViewById(R.id.cart_food);
            delete = itemView.findViewById(R.id.delete);
            good = itemView.findViewById(R.id.recommended);
            price = itemView.findViewById(R.id.price);
        }

        public void bind (Food food) {
            mFood = food;
            mNameFood.setText(food.getName());
            String s = "Rs "+food.getPrice();
            price.setText(s);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    food.setInCart(false);
                    food.setGood(false);
                    foods.remove(food);
                    compare();
                    mAdapter.notifyDataSetChanged();
                }
            });

            if(food.isGood()) {
                good.setVisibility(View.VISIBLE);
            }
            else good.setVisibility(View.INVISIBLE);

        }

        @Override
        public void onClick(View v) {
            Intent intent = FoodActivity.newIntent(getActivity(),mFood.getId());
            startActivity(intent);
        }
    }
    private class CartAdapter extends RecyclerView.Adapter<CartHolder> {
        private List<Food> mFoods;

        public CartAdapter(List<Food> foods) {
            mFoods = foods;
        }

        @Override
        public CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new CartHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(CartHolder holder, int position) {
            holder.bind(mFoods.get(position));
            holder.itemView.setOnClickListener(holder);
            MyAnimator.animation(getActivity(), holder.itemView, 200);
        }

        @Override
        public int getItemCount() {
            return mFoods.size();
        }
    }

    private void updateUI() {

        if(mAdapter == null) {
            foods = Foods.get().getCart();
            if(foods == null) { foods = new ArrayList<>(); }

            compare();
            mAdapter = new CartAdapter(foods);
            mRecyclerView.setAdapter(mAdapter);
        }

    }
    
    private void compare(){
        
        if(foods.size() == 0) return;

        for(Food f:foods) { f.setGood(false); }
        Food best = null;
        
        for(Food f:foods) {
            if(best ==  null) {best = f; continue;}

            float price=f.getPrice(),rating=f.getRating();

            if (price-best.getPrice()<=0 && rating-best.getRating()>0) best = f;
            else if((int)rating/4 > 0)
                if ((int)best.getRating()/4 < 0 && price-best.getPrice()>=0 && price-best.getPrice()<520) best = f;
                else if (price-best.getPrice()>=0 && price-best.getPrice()<100) best=f;
            else if (rating-best.getRating()>=1 &&price-best.getPrice()>=0 && price-best.getPrice()<200) best = f;

        }

        if(best != null)
            best.setGood(true);
    }

}

package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        private Food mFood;

        public CartHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_cart,parent,false));
            mNameFood = itemView.findViewById(R.id.cart_food);
            delete = itemView.findViewById(R.id.delete);
        }

        public void bind (Food food) {
            mFood = food;
            mNameFood.setText(food.getName());
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    food.setInCart(false);
                    foods.remove(food);
                    mAdapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent intent = FoodActivity.newIntent(getActivity(),mFood.getId());
            startActivity(intent);
        }
    }
    private class CartAdapter extends RecyclerView.Adapter<CartHolder> {
        private List<Food> mFoods;
        private List<Food> mFoodsFull;

        public CartAdapter(List<Food> foods) {
            mFoods = foods;
            mFoodsFull = new ArrayList<>(foods);
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
            mAdapter = new CartAdapter(foods);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}

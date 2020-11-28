package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        mRecyclerView = view.findViewById(R.id.list_food);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setQueryHint("Search...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private class FoodHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameFood;
        private Food mFood;

        public FoodHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_food, parent, false));

            mNameFood = itemView.findViewById(R.id.name_food);
        }

        public void bind(Food food) {
            mFood = food;
            mNameFood.setText(food.getName());

        }

        @Override
        public void onClick(View v) {
            Intent intent = FoodActivity.newIntent(getActivity(), mFood.getId());
            startActivity(intent);
        }
    }

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder> implements Filterable {
        private List<Food> mFoods;
        private List<Food> mFoodsFull;

        public FoodAdapter(List<Food> foods) {
            mFoods = foods;
            mFoodsFull = new ArrayList<>(foods);
        }

        @Override
        public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new FoodHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(FoodHolder holder, int position) {
            holder.bind(mFoods.get(position));
            holder.itemView.setOnClickListener(holder);
            MyAnimator.animation(getActivity(), holder.itemView, 200);
        }

        @Override
        public int getItemCount() {
            return mFoods.size();
        }

        @Override
        public Filter getFilter() {
            return foodsFilter;
        }

        private Filter foodsFilter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Food> FilteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    FilteredList.addAll(mFoodsFull);
                } else {
                    for (Food f : mFoodsFull) {
                        String search = constraint.toString().toLowerCase().trim();
                        if (f.getName().toLowerCase().contains(search)) {
                            FilteredList.add(f);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = FilteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFoods.clear();
                mFoods.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }


    private void updateUI() {

        if (mAdapter == null) {

            Foods f = Foods.get();
            List<Food> foods = f.getFoods();

            mAdapter = new FoodAdapter(foods);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}

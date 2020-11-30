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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;
    private List<Food> mFoods;
    private List<Food> mFoodsFull;
    private List<Food> Filtered;
    private List<Food> FilteredList;
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

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                MenuItem search = item;
                SearchView searchView = (SearchView) search.getActionView();
                searchView.setQueryHint("Search...");

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        mAdapter.getFilter().filter(query);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mAdapter.getFilter().filter(newText);
                        return false;
                    }
                });
                return true;
            case R.id.no_filter:
                filter(0, 0, true);
                return true;

            case R.id.below_150:
                filter(0f, 150f, false);
                return true;

            case R.id.below_300:
                filter(150, 300, false);
                return true;

            case R.id.below_600:
                filter(300, 600, false);
                return true;

            case R.id.below_800:
                filter(600, 800, false);
                return true;

            case R.id.above_800:
                filter(800, 1000, false);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

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

        public FoodAdapter(List<Food> foods) {
            mFoods = foods;
            mFoodsFull = new ArrayList<>(foods);
            Filtered = new ArrayList<>(foods);
            FilteredList = new ArrayList<>(foods);

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
                FilteredList.clear();

                if (constraint == null && constraint.length() == 0) {
                    FilteredList.addAll(mFoodsFull);
                }
                else {
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
                getList();
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

    private void filter(float from, float to, boolean no_filter) {

        Filtered.clear();
        if (no_filter) {
            Filtered.addAll(mFoodsFull);
        }
        else {
            for (Food f : mFoodsFull) {
                if (from <= f.getPrice() && f.getPrice() <= to) Filtered.add(f);
            }
        }

        getList();
    }
    private void getList() {

        List <Food> List = new ArrayList<>();
        for(Food f : Filtered){
            for(Food food : FilteredList){
                if(f.getName().equals(food.getName()))
                    List.add(f);
            }
        }

        mFoods.clear();
        mFoods.addAll(List);
        mAdapter.notifyDataSetChanged();
    }
}

package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Foods {

    private static Foods sFoods;
    private List<Food> mFoods;
    private List<Food> Cart;
    private Integer[] Top ={R.drawable.chickensupreme,R.drawable.butterscoth};
    private List<Food> TopFoods;

    private Foods() {

        mFoods = new ArrayList<>();

        Food food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.veggiesupreme);
        food.setName("Veggie Supreme Pizza");
        food.setDes("Loaded with Black olives,Green Capsicum,Mushroom,Onion & Sweetcorn.");
        food.setPrice(569.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chickensupreme);
        food.setName("Chicken Supreme Pizza");
        food.setDes("Loaded with chunky pieces of Herbed chicken,Schezwan Chicken Meatballs & Chicken Tikka");
        food.setPrice(629.00f);
        food.setRating(4.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.triplechickenfeast);
        food.setName("Triple chicken feast Pizza");
        food.setDes("Non-veg lovers Paradise.Loaded with Schezwan Chicken Meatballs, Herbed Chicken, Chicken Sausage, Green Capsicum, Onion, Red Paprika");
        food.setPrice(629.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.farmhouse);
        food.setName("Farmhouse Pizza");
        food.setDes("Delightful combination of onion, capsicum, tomato & grilled mushroom");
        food.setPrice(395.00f);
        food.setRating(4.3f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.veggieparadise);
        food.setName("Veggie Paradise Pizza");
        food.setDes("The awesome foursome! Golden corn, black olives, capsicum, red paprika");
        food.setPrice(395.00f);
        food.setRating(4.3f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chickensausage);
        food.setName("Chicken Sausage Pizza");
        food.setDes("American classic! Spicy, herbed chicken sausage on pizza");
        food.setPrice(305.00f);
        food.setRating(3.4f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.pepperbarbeque);
        food.setName("Pepper Barbecue Chicken Pizza");
        food.setDes("Pepper barbecue chicken for that extra zing");
        food.setPrice(335.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cheesycomfortveg);
        food.setName("Chessy Comfort Veg Pasta");
        food.setDes("Cheesy Creamy Pasta Comfort Topped With Onion, Green Capsicum, Red Capsicum & Sweet Corn");
        food.setPrice(169.00f);
        food.setRating(3.9f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cheesycomfortnonveg);
        food.setName("Chessy Comfort Non Veg Pasta");
        food.setDes("Cheesy Creamy Pasta Comfort Topped With Chicken Sausage, Onion, Green Capsicum & Red Capsicum");
        food.setPrice(189.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.spicedtomato);
        food.setName("Spiced Tomato Twist Veg Pasta");
        food.setDes("Tangy Flavourful Red Sauce Pasta Infused With Heavenly Herbs & Spices Topped With Onion, Green Capsicum & Red Capsicum");
        food.setPrice(149.00f);
        food.setRating(4.6f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.spicedtomatotwist);
        food.setName("Spiced Tomato Twist Non Veg Pasta");
        food.setDes("Tangy Flavourful Red Sauce Pasta Infused With Heavenly Herbs & Spices Topped With Chicken Sausage");
        food.setPrice(169.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.margique);
        food.setName("Margique Chocolate Pastry");
        food.setDes("Chocolaty heaven!");
        food.setPrice(65.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.butterscoth);
        food.setName("Butter scotch Pastry");
        food.setDes("Butter scotch Delight!");
        food.setPrice(45.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.pineapple);
        food.setName("Pineapple Pastry");
        food.setDes("Yummy!");
        food.setPrice(45.00f);
        food.setRating(4.0f);
        mFoods.add(food);

    }

    public void add (Food food){
        if(Cart == null) Cart = new ArrayList<>();

        Cart.add(food);
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

    public List<Food> getTopFood() {

        if(TopFoods == null) {

            TopFoods = new ArrayList<>();
            for (Food f:mFoods) {
                for(Integer i : Top){
                    if(f.getImage().equals(i))
                        TopFoods.add(f);
                }
            }
        }
        return TopFoods;
    }

    public List<Food> getCart() { return Cart; }

    public static Foods get() {
        if(sFoods == null) {
            sFoods = new Foods();
        }

        return sFoods;
    }
}

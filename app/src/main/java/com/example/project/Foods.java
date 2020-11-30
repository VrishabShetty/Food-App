package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Foods {

    private static Foods sFoods;
    private List<Food> mFoods;
    private List<Food> Cart;
    private Integer[] Top ={R.drawable.chickensupreme,R.drawable.alfredo,R.drawable.muttonluchnowibiryani,
            R.drawable.butterscoth,R.drawable.strawberry};
    private List<Food> TopFoods;

    private Foods() {

        mFoods = new ArrayList<>();

        //Pizza
        Food food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.veggiesupreme);
        food.setName("Veggie Supreme Pizza");
        food.setDes("Loaded with Black olives,Green Capsicum,Mushroom,Onion & Sweetcorn.");
        food.setURL("https://www.pizzahut.co.in/order/pizzas/?kind=veggie-supreme&modal=veggie-supreme-pan-personal&type=pizza");
        food.setPrice(569.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chickensupreme);
        food.setName("Chicken Supreme Pizza");
        food.setDes("Loaded with chunky pieces of Herbed chicken,Schezwan Chicken Meatballs & Chicken Tikka");
        food.setURL("https://www.pizzahut.co.in/order/pizzas/?kind=chicken-supreme&modal=chicken-supreme-pan-personal&type=pizza");
        food.setPrice(629.00f);
        food.setRating(4.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.triplechickenfeast);
        food.setName("Triple chicken feast Pizza");
        food.setDes("Non-veg lovers Paradise.Loaded with Schezwan Chicken Meatballs, Herbed Chicken, Chicken Sausage, Green Capsicum, Onion, Red Paprika");
        food.setURL("https://www.pizzahut.co.in/order/pizzas/?kind=triple-chicken-feast&modal=triple-chicken-feast-pan-personal&type=pizza");
        food.setPrice(629.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.margherita);
        food.setName("Margherita Pizza");
        food.setDes("Cheese lover's paradise!");
        food.setURL("https://www.pizzahut.co.in/order/pizzas/?kind=margherita&modal=margherita-pan-personal&type=pizza");
        food.setPrice(279.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cornchicken);
        food.setName("Chicken N Corn Delight Pizza");
        food.setDes("Chicken lover's heaven!");
        food.setURL("https://www.pizzahut.co.in/order/pizzas/?kind=chicken-n-corn-delight&modal=chicken-n-corn-delight-pan-personal&type=pizza");
        food.setPrice(279.00f);
        food.setRating(3.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.farmhouse);
        food.setName("Farmhouse Pizza");
        food.setDes("Delightful combination of onion, capsicum, tomato & grilled mushroom");
        food.setURL("https://pizzaonline.dominos.co.in/menu?categoryId=1&customise=4064");
        food.setPrice(395.00f);
        food.setRating(3.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.veggieparadise);
        food.setName("Veggie Paradise Pizza");
        food.setDes("The awesome foursome! Golden corn, black olives, capsicum, red paprika");
        food.setURL("https://pizzaonline.dominos.co.in/menu?categoryId=1&customise=4075");
        food.setPrice(395.00f);
        food.setRating(4.2f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chickensausage);
        food.setName("Chicken Sausage Pizza");
        food.setDes("American classic! Spicy, herbed chicken sausage on pizza");
        food.setURL("https://pizzaonline.dominos.co.in/menu?categoryId=1&customise=4083");
        food.setPrice(305.00f);
        food.setRating(3.4f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.pepperbarbeque);
        food.setName("Pepper Barbecue Chicken Pizza");
        food.setDes("Pepper barbecue chicken for that extra zing");
        food.setURL("https://pizzaonline.dominos.co.in/menu?categoryId=1&customise=4082");
        food.setPrice(335.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        //Biryani
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.murgtikka);
        food.setName("Murgh Tikka Biryani \n[Boneless, Served with Mint Raita] ");
        food.setDes("Charcoal-grilled, tender spiced chicken cooked to perfection & layered with fragrant long grain basmati rice.");
        food.setURL("https://www.behrouzbiryani.com/product/murgh-tikka-chicken-tikka-biryani-serves-1-1h12");
        food.setPrice(439.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.dumghost);
        food.setName("Dum Ghost Biryani \n[Classic Mutton Biryani, Boneless] ");
        food.setDes(" Succulent mutton pieces laid on a bed of long-grain rice are slow-cooked on charcoal fire with royal spices.");
        food.setURL("https://www.behrouzbiryani.com/product/dum-gosht-classic-mutton-biryani-boneless-serves-1-1gtr");
        food.setPrice(520.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.muttonluchnowibiryani);
        food.setName("Mutton Lucknowi Biryani");
        food.setDes("A flavourful biryani with a hint of fresh masalas, the meat and rice are cooked separately and then layered and dum cooked in the true khansama style in the handi");
        food.setURL("https://biryanibykilo.com/order-online/menu#45413");
        food.setPrice(645.00f);
        food.setRating(4.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chickenlucknow);
        food.setName("Chicken Lucknowi Biryani");
        food.setDes(". A flavourful biryani with a hint of fresh masalas, the chicken and rice are cooked separately and then layered and dum cooked in the true khansama style in the handi.");
        food.setURL("https://biryanibykilo.com/order-online/menu#45413");
        food.setPrice(460.00f);
        food.setRating(4.2f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.egg_hyderabadi_biryani);
        food.setName("Egg Hyderabadi Biryani");
        food.setDes("eggs which are marinated in a mixture of freshly ground BBK spices & layered with long grain basmati rice in the handi and slow-cooked in the sealed handi");
        food.setURL("https://biryanibykilo.com/order-online/menu#45412");
        food.setPrice(325.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.paneerbiryani);
        food.setName("Paneer Biryani");
        food.setDes("Fresh Paneer pieces marinated in freshly ground BBK spices and layered with long grain Daawat basmati rice & Dum cooked in a sealed handi. This paneer dum biryani is one of those meals that everyone in the family can agree on");
        food.setURL("https://biryanibykilo.com/order-online/menu#45412");
        food.setPrice(325.00f);
        food.setRating(3.8f);
        mFoods.add(food);

        //Pasta
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.alfredo);
        food.setName("Alfredo Pasta");
        food.setURL("https://sbarrodelivery.com/item/89035/alfredo-1");
        food.setPrice(190.00f);
        food.setRating(4.4f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cheesycomfortveg);
        food.setName("Chessy Comfort Veg Pasta");
        food.setDes("Cheesy Creamy Pasta Comfort Topped With Onion, Green Capsicum, Red Capsicum & Sweet Corn");
        food.setURL("https://www.pizzahut.co.in/order/sides/?modal=cheesy-comfort-veg-single&type=side");
        food.setPrice(169.00f);
        food.setRating(3.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cheesycomfortnonveg);
        food.setName("Chessy Comfort Non Veg Pasta");
        food.setDes("Cheesy Creamy Pasta Comfort Topped With Chicken Sausage, Onion, Green Capsicum & Red Capsicum");
        food.setURL("https://www.pizzahut.co.in/order/sides/?modal=cheesy-comfort-non-veg-single&type=side");
        food.setPrice(189.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.arrabiata);
        food.setName("Arrabiata Pasta");
        food.setDes("Pasta, Ragu Sauce, Bell Peppers, Corn, Ginger Garlic, Chopped Green Chilli, Grated Cheese & Parsely");
        food.setURL("https://sbarrodelivery.com/item/89036/arrabiata-1");
        food.setPrice(190.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.spicedtomato);
        food.setName("Spiced Tomato Twist Veg Pasta");
        food.setDes("Tangy Flavourful Red Sauce Pasta Infused With Heavenly Herbs & Spices Topped With Onion, Green Capsicum & Red Capsicum");
        food.setURL("https://www.pizzahut.co.in/order/sides/?modal=spiced-tomato-twist-veg-single&type=side");
        food.setPrice(149.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.spicedtomatotwist);
        food.setName("Spiced Tomato Twist Non Veg Pasta");
        food.setDes("Tangy Flavourful Red Sauce Pasta Infused With Heavenly Herbs & Spices Topped With Chicken Sausage");
        food.setURL("https://www.pizzahut.co.in/order/sides/?modal=spiced-tomato-twist-non-veg-single&type=side");
        food.setPrice(169.00f);
        food.setRating(4.7f);
        mFoods.add(food);

        //Pastry
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.butterscoth);
        food.setName("Butter scotch Pastry");
        food.setDes("Butter scotch Delight!");
        food.setURL("https://ribbonsandballoons.com/pastries/pineapple");
        food.setPrice(45.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.red_valvet);
        food.setName("Rich Red Velvet Pastry");
        food.setDes("Love everything red? Then this luxurious layered cake is for you where delectable cake meets irresistible cream cheese. The indulgence is absolutely worth it.");
        food.setURL("https://www.ovenstory.in/product/rich-red-velvet-pastry-1fpo");
        food.setPrice(163.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.chocog);
        food.setName("Chocolate Truffle Pastry");
        food.setDes("Simple yet elegant, Chocolate Truffle Pastry cake is the perfect feast for the season. Layers of soft chocolate sponge and dense but silky-smooth chocolate ganache makes this cake a celebration");
        food.setURL("https://www.ovenstory.in/product/chocolate-truffle-pastry-1fpn");
        food.setPrice(163.00f);
        food.setRating(4.2f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.margique);
        food.setName("Margique Chocolate Pastry");
        food.setDes("Chocolaty heaven!");
        food.setURL("https://ribbonsandballoons.com/pastries/magique");
        food.setPrice(65.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.pineapple);
        food.setName("Pineapple Pastry");
        food.setDes("Yummy!");
        food.setURL("https://ribbonsandballoons.com/pastries/pineapple");
        food.setPrice(45.00f);
        food.setRating(3.6f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.mango);
        food.setName("Mango Pastry");
        food.setDes("Brings you back that summer feeling");
        food.setURL("https://ribbonsandballoons.com/pastries/mango-delight");
        food.setPrice(50.00f);
        food.setRating(3.7f);
        mFoods.add(food);

        //Ice_Cream
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.dutch);
        food.setName("Dutch Chocolate Ice-Cream");
        food.setDes("Tempting chocolate ice cream with a distinct hint of cocoa. The mother of every chocolate ice cream creation");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/dutch-chocolate.html");
        food.setPrice(99.00f);
        food.setRating(4.2f);
        mFoods.add(food);
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.van);
        food.setName("Vanilla Ice-Cream");
        food.setDes("Not quite like a plain Jane, this is a rich, dense vanilla ice cream that you'll recommend to friends. Seriously creamy, seriously tasty, a lot can happen over a Vanilla ice cream!");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/vanilla.html");
        food.setPrice(89.00f);
        food.setRating(3.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.strawberry);
        food.setName("Fresh Strawberry Ice-Cream");
        food.setDes("Sublime strawberry flavoured ice cream laden with natural strawberry puree, as well as Strawberry fruit chunks. This Strawberry ice cream is a childhood favourite. Scrap that actually, it’s an all time favourite!");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/very-berry-strawberry.html");
        food.setPrice(99.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.mangoice);
        food.setName("Alphonso Mango Ice-Cream");
        food.setDes("Delicious alphonso based ice cream with the flavour highlighted by juicy alphonso pieces. Just go for this aam-azing mango ice cream!");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/alphonso-mango.html");
        food.setPrice(99.00f);
        food.setRating(4.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.litchi);
        food.setName("Fresh Litchi Ice-Cream");
        food.setDes("Litchi ice cream with fresh Litchi pieces makes for a lush, delicious treat!");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/fresh-litchi.html");
        food.setPrice(119.00f);
        food.setRating(4.3f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.coconut);
        food.setName("Fresh Tender Coconut Ice-Cream");
        food.setDes("Fresh Tender Coconut Ice cream filled with pieces of fresh coconut.");
        food.setURL("https://www.baskinrobbinsindia.com/ice-creams/scoops/fresh-tender-coconut.html");
        food.setPrice(99.00f);
        food.setRating(3.5f);
        mFoods.add(food);


        //MilkShake
        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.mangoshake);
        food.setName("Mango Madness Milkshake");
        food.setDes("Pure, creamy Alphonso Gold mixed with vanilla milk and chocolate fudge. This Mango flavoured milkshake will show you exactly why the mango is the king of fruits! Prepare for some mango madness!");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/mango-madness-milkshake.html");
        food.setPrice(199.00f);
        food.setRating(4.9f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.burst);
        food.setName("Chocolate Burst Milkshake");
        food.setDes("For all those crazy chocolate lovers, chocolate ice cream blended with vanilla milk is nothing but happyness! No such thing as too much chocolate. Perfect for all the chocoholics out there!");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/chocolate-burst-milkshake.html");
        food.setPrice(159.00f);
        food.setRating(3.9f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.vanilla);
        food.setName("Vanilla Crumble Milkshake");
        food.setDes("Perfect medley of milk, vanilla ice cream, glucose biscuits topped with chocolate fudge. Sometimes, the classic flavour is the best way to go! This good ol’ Vanilla milkshake is as delicious as they come");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/vanilla-crumble-milkshake.html");
        food.setPrice(175.00f);
        food.setRating(4.0f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.almond);
        food.setName("Almond Milkshake");
        food.setDes("A delicious combination of vanilla and coffee ice cream blended together with milk, poured over hot fudge sauce and topped with cream and chocolate syrup");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/almond-milkshake.html");
        food.setPrice(109.00f);
        food.setRating(3.5f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.cookie);
        food.setName("Cookies & Cream Milkshake");
        food.setDes("A classic combination of vanilla ice cream and Oreo cookies blended together with milk, poured over hot fudge sauce and topped with cream, Oreo crumbs and chocolate syrup. This cookies and cream milkshake promises to delight one and all!");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/cookies-n-cream.html");
        food.setPrice(199.00f);
        food.setRating(4.8f);
        mFoods.add(food);

        food = new Food();
        food.setInCart(false);
        food.setGood(false);
        food.setImage(R.drawable.coffee);
        food.setName("Cheeky Coffee Milkshake");
        food.setDes("A delicious combination of vanilla and coffee ice cream blended together with milk, poured over hot fudge sauce and topped with cream and chocolate syrup. This coffee milkshake promises to leave you slurping for more!");
        food.setURL("https://www.baskinrobbinsindia.com/thick-shakes/cheeky-coffee.html");
        food.setPrice(199.00f);
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
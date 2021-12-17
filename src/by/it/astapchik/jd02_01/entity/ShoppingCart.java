package by.it.astapchik.jd02_01.entity;

import java.util.HashMap;

public class ShoppingCart {

    private final HashMap<Good, Integer> cart;
    private String cartN;

    public void cartNumber(int number) {
        cartN = "Cart №: " + number + ".";
    }

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addToCart(Good good, int number){
        this.cart.put(good, number);
    }

    @Override
    public String toString() {
        return cartN;
    }
}

package by.it.konon.jd02_02.entity;

import java.util.HashMap;

public class ShoppingCard {

    private final HashMap<Good, Integer> cart;

    public ShoppingCard() {
        this.cart = new HashMap<>();
    }

    public void addGoodToCart(Good good, int count) {
        this.cart.put(good, count);
    }

    public int getGoodCount(Good good) {
        return this.cart.get(good);
    }

    public HashMap<Good, Integer> getCart() {
        return this.cart;
    }

}

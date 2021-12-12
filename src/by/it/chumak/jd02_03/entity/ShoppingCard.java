package by.it.chumak.jd02_03.entity;

import java.util.HashMap;

public class ShoppingCard {

    private final HashMap<Good, Integer> CART;

    public ShoppingCard() {
        this.CART = new HashMap<>();
    }

    public void addGoodToCart(Good good, int count) {
        this.CART.put(good, count);
    }

    public int getGoodCount(Good good) {
        return this.CART.get(good);
    }

    public HashMap<Good, Integer> getCart() {
        return this.CART;
    }

}

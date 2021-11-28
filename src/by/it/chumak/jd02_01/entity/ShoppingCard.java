package by.it.chumak.jd02_01.entity;

import java.util.HashMap;

public class ShoppingCard {

    private final HashMap<Integer, String> cart;

    public ShoppingCard() {
        this.cart = new HashMap<>();
    }

    public ShoppingCard(HashMap<Integer, String> cart) {
        this.cart = cart;
    }

    public HashMap<Integer, String> getCart() {
        return cart;
    }

}

package by.it.konon.jd02_01.service;

import by.it.konon.jd02_01.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}

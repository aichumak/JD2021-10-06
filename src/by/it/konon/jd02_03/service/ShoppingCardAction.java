package by.it.konon.jd02_03.service;

import by.it.konon.jd02_03.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}

package by.it.konon.jd02_02.service;

import by.it.konon.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}

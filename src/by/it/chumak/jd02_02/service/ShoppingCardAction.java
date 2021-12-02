package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}

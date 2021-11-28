package by.it.chumak.jd02_01.service;

import by.it.chumak.jd02_01.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}

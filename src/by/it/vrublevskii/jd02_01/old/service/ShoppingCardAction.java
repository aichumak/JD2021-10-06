package by.it.vrublevskii.jd02_01.old.service;

import by.it.vrublevskii.jd02_01.old.entity.Good;

public interface ShoppingCardAction {
        void takeCart();             //взял корзину
        int putToCart(Good good);    //положил товар в корзину(возвращает число товаров)
}

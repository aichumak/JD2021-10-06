package by.it.vrublevskii.jd02_02.old.service;

import by.it.vrublevskii.jd02_02.old.entity.Good;

public interface ShoppingCardAction {
        void takeCart();             //взял корзину
        int putToCart(Good good);    //положил товар в корзину(возвращает число товаров)
}

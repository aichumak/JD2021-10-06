package by.it.astapchik.jd02_01.service;

import by.it.astapchik.jd02_01.entity.Good;

public interface ShoppingCartAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}

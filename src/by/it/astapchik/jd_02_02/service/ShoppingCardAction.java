package by.it.astapchik.jd_02_02.service;

import by.it.astapchik.jd_02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}

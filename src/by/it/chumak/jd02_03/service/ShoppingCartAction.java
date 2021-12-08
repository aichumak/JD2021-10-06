package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;

public interface ShoppingCartAction {

    void takeCart(Customer customer);

    void putToCart(Customer customer, Good good);
}

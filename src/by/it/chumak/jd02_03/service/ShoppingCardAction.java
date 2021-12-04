package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;

public interface ShoppingCardAction {

    void takeCart(Customer customer);

    void putToCart(Customer customer, Good good);
}

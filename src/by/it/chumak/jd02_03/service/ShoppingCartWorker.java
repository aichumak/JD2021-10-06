package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.CustomerType;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.ShoppingCard;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

public class ShoppingCartWorker implements ShoppingCartAction {

    public ShoppingCartWorker() {
    }

    @Override
    public void takeCart(Customer customer) {
//        new Thread(() -> {
//            try {
//            store.getCART_QUEUE().put(1);
        if (customer.getCustomerType() == CustomerType.Pensioner) {
            Timeout.oversleep(150, 450);
        } else {
            Timeout.oversleep(100, 300);
        }
        customer.setShoppingCard(new ShoppingCard());
        System.out.println(customer + " took the shopping cart");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    @Override
    public void putToCart(Customer customer, Good good) {
        int goodsQuantity;

        if (customer.getCustomerType() == CustomerType.Pensioner) {
            Timeout.oversleep(150, 450);
            goodsQuantity = RandomGenerator.get(1, 5);
        } else {
            Timeout.oversleep(100, 300);
            if (customer.getCustomerType() == CustomerType.Student) {
                goodsQuantity = RandomGenerator.get(1, 2);
            } else {
                goodsQuantity = RandomGenerator.get(1, 5);
            }
        }
        System.out.printf("%s put %s to the shopping cart%n", customer, good.getName());
        customer.getShoppingCard().addGoodToCart(good, goodsQuantity);
    }
}

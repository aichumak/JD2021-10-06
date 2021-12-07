package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.*;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

public class ShoppingCartWorker implements ShoppingCartAction {

    public ShoppingCartWorker() {
    }

    @Override
    public void takeCart(Customer customer) {
        StoreReportPrinter cashiersReportPrinter = new StoreReportPrinter();

        if (customer.getCustomerType() == CustomerType.Pensioner) {
            Timeout.oversleep(150, 450);
        } else {
            Timeout.oversleep(100, 300);
        }
        customer.setShoppingCard(new ShoppingCard());
        cashiersReportPrinter.printStatus(customer + " took the shopping cart");
    }

    @Override
    public void putToCart(Customer customer, Good good) {
        int goodsQuantity;
        StoreReportPrinter storeReportPrinter = new StoreReportPrinter();

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

        storeReportPrinter.printStatus(String.format("%s put %s to the shopping cart", customer, good.getName()));
        customer.getShoppingCard().addGoodToCart(good, goodsQuantity);
    }
}

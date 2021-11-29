package by.it.drankevich.jd02_01.service;

import by.it.drankevich.jd02_01.entity.Customer;
import by.it.drankevich.jd02_01.entity.Good;
import by.it.drankevich.jd02_01.entity.ShoppingCart;
import by.it.drankevich.jd02_01.helper.RandomGenerator;
import by.it.drankevich.jd02_01.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final ShoppingCart shoppingCart;

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        goOut();

    }

    public CustomerWorker(Customer customer, ShoppingCart shoppingCart) {
        this.customer = customer;
        this.shoppingCart=shoppingCart;
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");

    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        Good good = null;
        for (int i = 0; i < RandomGenerator.get(2, 5); i++) {
            int timeout = RandomGenerator.get(500, 2000);
            Timeout.sleep(timeout);
            good = PriceListRepo.goodChoise();
            System.out.println(customer + " choose" + good);
            putToCart(good);
        }
        System.out.println(customer + " finished to choose good");

        return good;

    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the Shop");

    }

    @Override
    public void takeCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println(customer + " took the takeCart");
        int timeout = RandomGenerator.get(100, 300);
        Timeout.sleep(timeout);

    }

    @Override
    public int putToCart(Good good) {

        int goodsCount = shoppingCart.add(good);
        System.out.println(customer + " put good to Cart, all goods: " + (goodsCount));
        int timeout = RandomGenerator.get(100, 300);
        Timeout.sleep(timeout);

        return goodsCount;
    }
}

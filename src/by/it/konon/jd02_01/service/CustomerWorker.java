package by.it.konon.jd02_01.service;

import by.it.konon.jd02_01.entity.Customer;
import by.it.konon.jd02_01.entity.Good;
import by.it.konon.jd02_01.helper.RandomGenerator;
import by.it.konon.jd02_01.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        putToCart();
        goOut();
    }

    private void putToCart() {
        System.out.println(customer+ " Eat");
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;

    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");

    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");


    }

    @Override
    public Good chooseGood() {

        System.out.println(customer + " started to choose good");

        int timeout = RandomGenerator.get(500, 2000);
        Timeout.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " chose " + good);
        System.out.println(customer + " finished to choose good");
        return good;
    }

    @Override
    public int putToCart(Good good) {

        return 0;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leave the store");

    }


}

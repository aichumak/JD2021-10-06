package by.it.brutski.jd02_01.service;

import by.it.brutski.jd02_01.entity.Customer;
import by.it.brutski.jd02_01.entity.Good;
import by.it.brutski.jd02_01.helper.RandomGenerator;
import by.it.brutski.jd02_01.helper.TimeOut;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to shop");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " selects a product ");
        int timeout = RandomGenerator.get(500, 2000);
        TimeOut.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " chose " + good);
        System.out.println(customer + " finishes choosing a product");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the shop");
    }
}

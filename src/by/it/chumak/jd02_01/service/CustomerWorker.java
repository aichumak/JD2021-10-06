package by.it.chumak.jd02_01.service;

import by.it._classwork_.jd02_02.entity.Customer;
import by.it._classwork_.jd02_02.entity.Good;
import by.it._classwork_.jd02_02.helper.RandomGenerator;
import by.it._classwork_.jd02_02.helper.Timeout;
import by.it._classwork_.jd02_02.service.CustomerAction;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer + " choose " + good);
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");
        int timeout = RandomGenerator.get(500, 2000);
        Timeout.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " finished to choose good");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the Shop");

    }
}

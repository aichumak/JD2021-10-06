package by.it.vrublevskii.jd02_01.service;

import by.it.vrublevskii.jd02_01.entity.Customer;
import by.it.vrublevskii.jd02_01.entity.Good;
import by.it.vrublevskii.jd02_01.helper.RandomGenerator;
import by.it.vrublevskii.jd02_01.helper.Timeout;

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
        System.out.println(customer + " entered the store");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started choosing goods");
        int timeout = RandomGenerator.get(500, 2000);
        Timeout.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " chosed " + good);
        System.out.println(customer + " chose good" + good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the store");
    }
}

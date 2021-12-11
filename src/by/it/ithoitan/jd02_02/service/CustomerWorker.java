package by.it.ithoitan.jd02_02.service;

import by.it.ithoitan.jd02_02.entity.Customer;
import by.it.ithoitan.jd02_02.entity.Good;
import by.it.ithoitan.jd02_02.entity.Store;
import by.it.ithoitan.jd02_02.helper.RandomGenerator;
import by.it.ithoitan.jd02_02.helper.TimeOut;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;
    private final Store store;

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer + " choose " + good);
        goToQueue();
        goOut();
        store.getManager().outCustomer();
    }

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().inCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");

    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");
        int timeout = RandomGenerator.get(500,2000);
        TimeOut.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " finished to choose good");
        return good;
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " go to the Queue");
        synchronized (customer.getMonitor()) {
            store.getQueue().add(customer);
            customer.setFlagWaining(true);
            try {
                while (customer.isFlagWaining()) {
                    customer.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(customer + " finished to choose good");
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaved the Shop");

    }
}

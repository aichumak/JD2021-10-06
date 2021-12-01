package by.it._classwork_.jd02_02.service;

import by.it._classwork_.jd02_02.entity.Customer;
import by.it._classwork_.jd02_02.entity.Good;
import by.it._classwork_.jd02_02.entity.Store;
import by.it._classwork_.jd02_02.helper.RandomGenerator;
import by.it._classwork_.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        store.getManager().addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer + " choose " + good);
        goToQueue();
        goOut();
        store.getManager().finishedCustomer();
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
        System.out.println(customer + " leaves the Shop");
    }


}

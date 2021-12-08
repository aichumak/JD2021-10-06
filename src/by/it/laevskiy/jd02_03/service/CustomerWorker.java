package by.it.laevskiy.jd02_03.service;

import by.it.laevskiy.jd02_03.entity.Customer;
import by.it.laevskiy.jd02_03.entity.Good;
import by.it.laevskiy.jd02_03.entity.Store;
import by.it.laevskiy.jd02_03.helper.RandomGenerator;
import by.it.laevskiy.jd02_03.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Store store;

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        takeCart();
        goToQueue();
        goOut();
        store.getManager().finishedCustomer();
    }


    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        store.getManager().addCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");
        int timeout = RandomGenerator.get(500, 2000);
        Timeout.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose good");
        return good;
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " go to the Queue");
        synchronized (customer.getMonitor()){
            store.getQueue().add(customer);
            customer.setFlagWaiting(true);
            try {
                while (customer.isFlagWaiting()) {
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
        System.out.println(customer + " leaves the store");
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " took the cart");
        int timeout = RandomGenerator.get(100, 300);
    }

    @Override
    public int putToCart(Good good) {
        return 0;

    }
}

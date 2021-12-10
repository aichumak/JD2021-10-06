package by.it.brutski.jd02_02.service;

import by.it.brutski.jd02_02.entity.Customer;
import by.it.brutski.jd02_02.entity.Good;
import by.it.brutski.jd02_02.entity.Store;
import by.it.brutski.jd02_02.helper.RandomGenerator;
import by.it.brutski.jd02_02.helper.TimeOut;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;
    private final Store store;

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goToQueue();
        goOut();
        store.getManager().OutCustomer();
    }

    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        store.getManager().InCustomer();
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
    public void goToQueue() {
        System.out.println(customer + " go to the Queue");
        synchronized (customer.getMonitor()){
            store.getQueue().add(customer);
            customer.setFlag(true);
            try {
                while (customer.isFlag()){
                    customer.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(customer + " finish");
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the shop");
    }
}

package by.it.astapchik.jd_02_02.service;

import by.it._classwork_.jd02_02.helper.Timeout;
import by.it.astapchik.jd_02_02.entity.Customer;
import by.it.astapchik.jd_02_02.entity.Good;
import by.it.astapchik.jd_02_02.entity.Store;
import by.it.astapchik.jd_02_02.helper.GenerateRandomNumbers;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void run() {
        store.getManager().addCustomer();
        enteredStore();
        chooseGood();
        goToQueue();
        goOut();
        store.getManager().removeCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the shop.");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " chooses products.");
        int timeout = GenerateRandomNumbers.get(500, 2000);
        Timeout.sleep(timeout  );
        Good good = new Good();
        System.out.println(customer + " has chosen " + good);
        System.out.println(customer + " finished choosing products.");
        return new Good();

    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " in the queue. ");
        synchronized (customer.getMonitor()){
            store.getQueue().add(customer);
            customer.setFlagWait(true);
            try {
                while (customer.isFlagWait()){
                    customer.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(customer + " finished to choose products.");
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the shop.");
    }




    @Override
    public void takeCart() {

    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}

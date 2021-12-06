package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Store;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer CUSTOMER;
    private final Store STORE;

    public CustomerWorker(Customer customer, Store store) {
        this.CUSTOMER = customer;
        this.STORE = store;
        store.getManager().addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        getShoppingCart();
        chooseGoods();
        goToQueueToCheckoutStore();
        goOut();
        STORE.getManager().finishedCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(CUSTOMER + " entered to Shop");
    }

    @Override
    public void goOut() {
        System.out.println(CUSTOMER + " leaves shop");
    }

    @Override
    public void goToQueue() {
        System.out.println(CUSTOMER + " go to the Queue");
        synchronized (CUSTOMER.getMonitor()) {
            STORE.getQueue().add(CUSTOMER);
            CUSTOMER.setFlagWaiting(true);
            try {
                while (CUSTOMER.isFlagWaiting()) {
                    CUSTOMER.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getShoppingCart() {
        ShoppingCartWorker shoppingCartWorker = new ShoppingCartWorker();
        shoppingCartWorker.takeCart(CUSTOMER);
    }

    private void chooseGoods() {
        ExecutorService executors = Executors.newFixedThreadPool(1);
        executors.execute(new ChooseGoodsWorker(STORE, CUSTOMER));
        executors.shutdown();

        try {
            //noinspection ResultOfMethodCallIgnored
            executors.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void goToQueueToCheckoutStore() {
        if (CUSTOMER.getShoppingCard().getCart().size() > 0) {
            goToQueue();
        }
    }

}

package by.it.drankevich.jd02_02.service;

import by.it.drankevich.jd02_02.entity.Store;
import by.it.drankevich.jd02_02.entity.*;
import by.it.drankevich.jd02_02.helper.RandomGenerator;
import by.it.drankevich.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final ShoppingCart shoppingCart;
    private final Store store;

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        if(shoppingCart.cart.size()!=0) {
            goToQueue();
        }
        goOut();
        synchronized (StoreWorker.monitorNumberPeopleInStore) {
            StoreWorker.numberPeopleInStore = StoreWorker.numberPeopleInStore - 1;
        }
        store.getManager().finishedCustomer();


    }

    public CustomerWorker(Customer customer, Store store, ShoppingCart shoppingCart) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.store = store;
        store.getManager().addCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");

    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        Good good = null;
        int numberProducts;
        if (customer instanceof Student) {
            numberProducts = RandomGenerator.get(2);
        } else {
            numberProducts = RandomGenerator.get(2, 5);
        }

        for (int i = 0; i < numberProducts; i++) {
            int timeout = RandomGenerator.get(500, 2000);
            if (customer instanceof Pensioner) {
                timeout = (int) (timeout * 1.5);
            }
            Timeout.sleep(timeout);
            good = PriceListRepo.goodChoise();
            System.out.println(customer + " choose" + good);
            customer.setTotal(good.getPrice());
            putToCart(good);

        }
        System.out.println(customer + " finished to choose good "+shoppingCart.cart.toString());

        return good;

    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " go to the queue");
        synchronized (customer.getMonitor()) {
            store.getQueue().addCustomer(customer);
            customer.setFlagWaiting(true);
            while (customer.isFlagWaiting()) {
                try {
                    customer.getMonitor().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the Shop");


    }

    @Override
    public void takeCart() {
        System.out.println(customer + " took the takeCart");
        int timeout = RandomGenerator.get(100, 300);
        if (customer instanceof Pensioner) {
            timeout = (int) (timeout * 1.5);
        }
        Timeout.sleep(timeout);

    }

    @Override
    public int putToCart(Good good) {

        int goodsCount = shoppingCart.add(good);
        System.out.println(customer + " put good to Cart, all goods: " + (goodsCount));
        int timeout = RandomGenerator.get(100, 300);
        if (customer instanceof Pensioner) {
            timeout = (int) (timeout * 1.5);
        }
        Timeout.sleep(timeout);

        return goodsCount;
    }
}

package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.*;
import by.it.chumak.jd02_02.helper.RandomGenerator;
import by.it.chumak.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

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
        takeCart();
        chooseGoodsAndPutItToCart();
        if (CUSTOMER.getShoppingCard().getCart().size() > 0) {
            goToQueue();
        }
        goOut();
        STORE.getManager().finishedCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(CUSTOMER + " entered to Shop");
    }

    @Override
    public void takeCart() {
        if (CUSTOMER.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
        } else {
            oversleep(100, 300);
        }
        CUSTOMER.setShoppingCard(new ShoppingCard());
        System.out.println(CUSTOMER + " took the shopping cart");
    }

    @Override
    public Good chooseGood() {
        System.out.println(CUSTOMER + " started to choose good");

        if (CUSTOMER.getCustomerType() == CustomerType.Pensioner) {
            oversleep(750, 3000);
        } else {
            oversleep(500, 2000);
        }

        String nameSelectedGood = STORE.getStorePriceList().chooseGoodFromPriceList();
        System.out.println(CUSTOMER + " finished to choose good");
        return new Good(nameSelectedGood);
    }

    @Override
    public void goOut() {
        System.out.println(CUSTOMER + " leaves shop");
    }


    @Override
    public int putToCart(Good good) {
        int goodsQuantity;

        if (CUSTOMER.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
            goodsQuantity = RandomGenerator.get(1, 5);
        } else {
            oversleep(100, 300);
            if (CUSTOMER.getCustomerType() == CustomerType.Student) {
                goodsQuantity = RandomGenerator.get(1, 2);
            } else {
                goodsQuantity = RandomGenerator.get(1, 5);
            }
        }
        System.out.printf("%s put %s to the shopping cart%n", CUSTOMER, good.getName());

        CUSTOMER.getShoppingCard().addGoodToCart(good, goodsQuantity);

        return goodsQuantity;
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

    private void chooseGoodsAndPutItToCart() {
        int goodsCounter;

        if (CUSTOMER.getCustomerType() == CustomerType.Student) {
            goodsCounter = RandomGenerator.get(0, 2);
        } else {
            goodsCounter = RandomGenerator.get(2, 5);
        }

        for (int i = 0; i < goodsCounter; i++) {
            Good good = chooseGood();
            System.out.printf("%s choose %s that costs $%.2f%n", CUSTOMER, good.getName(), STORE.getStorePriceList().getGoodsPrice(good.getName()));
            CUSTOMER.getShoppingCard().addGoodToCart(good, putToCart(good));
            CUSTOMER.setTotal(CUSTOMER.getTotal() + (CUSTOMER.getShoppingCard().getGoodCount(good) * STORE.getStorePriceList().getGoodsPrice(good.getName())));
        }
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }

}

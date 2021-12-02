package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.*;
import by.it.chumak.jd02_02.helper.RandomGenerator;
import by.it.chumak.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGoodsAndPutItToCart();
        if (customer.getShoppingCard().getCart().size() > 0) {
            goToQueue();
        }
        goOut();
        store.getManager().finishedCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");
    }

    @Override
    public void takeCart() {
        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
        } else {
            oversleep(100, 300);
        }
        customer.setShoppingCard(new ShoppingCard());
        System.out.println(customer + " took the shopping cart");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");

        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(750, 3000);
        } else {
            oversleep(500, 2000);
        }

        String nameSelectedGood = store.getStorePriceList().chooseGoodFromPriceList();
        System.out.println(customer + " finished to choose good");
        return new Good(nameSelectedGood, store.getStorePriceList().getGoodsPrice(nameSelectedGood));
    }

    @Override
    public void goOut() {
        //customersCountRepo.removeCustomer();
        System.out.println(customer + " leaves shop");
        //System.out.printf("%s bought goods: %s, for a total of $%.2f and leaves the Shop%n", customer, shoppingCard.getGoodsList(), customer.getTotal());
    }


    @Override
    public int putToCart(Good good) {
        int goodsQuantity;

        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
            goodsQuantity = RandomGenerator.get(1, 5);
        } else {
            oversleep(100, 300);
            if (customer.getCustomerType() == CustomerType.Student) {
                goodsQuantity = RandomGenerator.get(1, 2);
            } else {
                goodsQuantity = RandomGenerator.get(1, 5);
            }
        }
        System.out.printf("%s put %s to the shopping cart%n", customer, good.getName());

        customer.getShoppingCard().addGoodToCart(good, goodsQuantity);

        return goodsQuantity;
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " go to the Queue");
        synchronized (customer.getMonitor()) {
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
    }

    private void chooseGoodsAndPutItToCart() {
        int goodsCounter;

        if (customer.getCustomerType() == CustomerType.Student) {
            goodsCounter = RandomGenerator.get(0, 2);
        } else {
            goodsCounter = RandomGenerator.get(2, 5);
        }

        for (int i = 0; i < goodsCounter; i++) {
            Good good = chooseGood();
            System.out.printf("%s choose %s that costs $%.2f%n", customer, good.getName(), store.getStorePriceList().getGoodsPrice(good.getName()));
            customer.getShoppingCard().addGoodToCart(good, putToCart(good));
            customer.setTotal(customer.getTotal() + (customer.getShoppingCard().getGoodCount(good) * store.getStorePriceList().getGoodsPrice(good.getName())));
        }
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }

}

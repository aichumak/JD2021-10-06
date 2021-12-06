package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.CustomerType;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.Store;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

import java.util.concurrent.Semaphore;

public class ChooseGoodsWorker implements ChooseGoodsActions, Runnable {
    private final Store STORE;
    private final Customer CUSTOMER;
    private final Semaphore SEMAPHORE;


    public ChooseGoodsWorker(Store store, Customer customer) {
        this.STORE = store;
        this.CUSTOMER = customer;
        this.SEMAPHORE = store.getSEMAPHORE();
    }

    @Override
    public void run() {
        try {
            SEMAPHORE.acquire();
            chooseGoodsAndPutItToCart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            SEMAPHORE.release();
        }
    }

    @Override
    public void chooseGoodsAndPutItToCart() {
        ShoppingCartWorker shoppingCartWorker = new ShoppingCartWorker();
        int goodsCounter;

        if (CUSTOMER.getCustomerType() == CustomerType.Student) {
            goodsCounter = RandomGenerator.get(0, 2);
        } else {
            goodsCounter = RandomGenerator.get(2, 5);
        }

        for (int i = 0; i < goodsCounter; i++) {
            Good good = chooseGood();
            System.out.printf("%s choose %s that costs $%.2f%n", CUSTOMER, good.getName(), STORE.getStorePriceList().getGoodsPrice(good.getName()));
            shoppingCartWorker.putToCart(CUSTOMER, good);
            CUSTOMER.setTotal(CUSTOMER.getTotal() + (CUSTOMER.getShoppingCard().getGoodCount(good) * STORE.getStorePriceList().getGoodsPrice(good.getName())));
        }
    }

    public Good chooseGood() {
        System.out.println(CUSTOMER + " started to choose good");

        if (CUSTOMER.getCustomerType() == CustomerType.Pensioner) {
            Timeout.oversleep(750, 3000);
        } else {
            Timeout.oversleep(500, 2000);
        }

        String nameSelectedGood = STORE.getStorePriceList().chooseGoodFromPriceList();
        System.out.println(CUSTOMER + " finished to choose good");
        return new Good(nameSelectedGood);
    }


}

package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.*;
import by.it.chumak.jd02_02.helper.PriceListRepo;
import by.it.chumak.jd02_02.helper.RandomGenerator;
import by.it.chumak.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

    private final Customer customer;
    private final CustomersCountRepo customersCountRepo;
    private final PriceListRepo priceListRepo;
    private ShoppingCard shoppingCard;
    private final Store store;

    public CustomerWorker(Customer customer, CustomersCountRepo customersCountRepo, PriceListRepo priceListRepo, Store store) {
        this.customer = customer;
        this.customersCountRepo = customersCountRepo;
        this.priceListRepo = priceListRepo;
        this.store = store;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGoodsAndPutItToCart();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");

        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(750, 3000);
        } else {
            oversleep(500, 2000);
        }

        String nameSelectedGood = priceListRepo.chooseGoodFromPriceList();
        System.out.println(customer + " finished to choose good");
        return new Good(nameSelectedGood, priceListRepo.getGoodsPrice(nameSelectedGood));
    }

    @Override
    public void goOut() {
        customersCountRepo.removeCustomer();
        System.out.printf("%s bought goods: %s, for a total of $%.2f and leaves the Shop%n", customer, shoppingCard.getGoodsList(), customer.getTotal());
    }

    @Override
    public void takeCart() {
        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
        } else {
            oversleep(100, 300);
        }
        shoppingCard = new ShoppingCard();
        System.out.println(customer + " took the shopping cart");
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

        shoppingCard.addGoodToCart(good, goodsQuantity);

        return goodsQuantity;
    }

    @Override
    public void goToQueue() {

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
            System.out.printf("%s choose %s that costs $%.2f%n", customer, good.getName(), good.getPrice());
            shoppingCard.addGoodToCart(good, putToCart(good));
            customer.setTotal(customer.getTotal() + (shoppingCard.getGoodCount(good) * good.getPrice()));
        }
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }



}

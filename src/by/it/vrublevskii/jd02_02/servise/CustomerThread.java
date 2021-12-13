package by.it.vrublevskii.jd02_02.servise;

import by.it.vrublevskii.jd02_02.entity.*;
import by.it.vrublevskii.jd02_02.helper.GoodGenerator;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

public class CustomerThread extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final PriceListRepo priceListRepo;
    private final Store store;


    private int goodsInCard = 0;

    public CustomerThread(Store store, Customer customer, PriceListRepo priceListRepo) {
        this.store = store;
        this.customer = customer;
        this.priceListRepo = priceListRepo;
        store.getManager().addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int customerNeedsGoodsNumber;
        if (customer.getType().equals("Student")) {
            customerNeedsGoodsNumber = RandomGenerator.get(0, 2);
        } else {
            customerNeedsGoodsNumber = RandomGenerator.get(2, 5);
        }
            for (int j = 0; j < customerNeedsGoodsNumber; j++) {
                Good good = chooseGood();
                putToCart(good);
            }
        goToQueue();
        goOut();
        store.getManager().terminateCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the store");
    }

    @Override
    public void takeCart() {
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")) {
            coefficient = 1.5;
        }
        int timeout = (int) (RandomGenerator.get(100, 300) * coefficient);
        Timeout.sleep(timeout);
        System.out.println(customer + " takes a cart");
    }

    @Override
    public Good chooseGood() {
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")) {
            coefficient = 1.5;
        }
        System.out.println(customer + " is choosing goods");
        int timeout = (int) (RandomGenerator.get(500, 2000) * coefficient);
        Timeout.sleep(timeout);
        Good good = GoodGenerator.get(priceListRepo);
        customer.getShoppingCart().add(good);
        System.out.println(customer + " chose " + good);
        return good;
    }

    @Override
    public int putToCart(Good good) {
        goodsInCard++;
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")) {
            coefficient = 1.5;
        }
        int timeout = (int) (RandomGenerator.get(100, 300) * coefficient);
        Timeout.sleep(timeout);
        System.out.println(customer + " puts " + good + " in the cart");
        return goodsInCard;
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " goes to queue");
        synchronized (customer.getMonitor()){
            store.getQueue().add(customer);
            customer.setFlagWait(true);
            try {
                while(customer.isFlagWait()){
                    customer.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(customer + " lives the queue");

    }

    @Override
    public void goOut() {
        System.out.printf("%s leaves the store. %20s Goods bought: %d%n", customer, "", goodsInCard);
    }

}

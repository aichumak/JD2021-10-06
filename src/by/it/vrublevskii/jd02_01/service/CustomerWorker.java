package by.it.vrublevskii.jd02_01.service;

import by.it.vrublevskii.jd02_01.entity.Customer;
import by.it.vrublevskii.jd02_01.entity.Good;
import by.it.vrublevskii.jd02_01.entity.PriceListRepo;
import by.it.vrublevskii.jd02_01.helper.RandomGenerator;
import by.it.vrublevskii.jd02_01.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final PriceListRepo priceListRepo;
    private int goodsInCard = 0;

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int i = RandomGenerator.get(2, 5);
        for (int j = 0; j < i; j++) {
            Good good = chooseGood();
            putToCart(good);
        }

        goOut();
    }

    public CustomerWorker(Customer customer, PriceListRepo priceListRepo) {
        this.customer = customer;
        this.priceListRepo = priceListRepo;
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the store");
    }

    @Override
    public void takeCart() {
        int timeout = RandomGenerator.get(100, 300);
        Timeout.sleep(timeout);
        System.out.println(customer + " takes a cart");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " is choosing goods");
        int timeout = RandomGenerator.get(500, 2000);
        Timeout.sleep(timeout);
        int index = RandomGenerator.get(0, 10);
        Good good = new Good(priceListRepo.getGoodName(index), priceListRepo.getGoodPrice(index));
        System.out.println(customer + " chose " + good);
        return good;
    }

    @Override
    public int putToCart(Good good) {
        goodsInCard++;
        int timeout = RandomGenerator.get(100, 300);
        Timeout.sleep(timeout);
        System.out.println(customer + " puts " + good + " in the cart");
        System.out.println("Goods in the cart total: " + goodsInCard);


//        System.out.println(good.getName() + good.getPrice());

        return 0;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the store");
    }
}

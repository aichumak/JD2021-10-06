package by.it.chumak.jd02_01.service;

import by.it.chumak.jd02_01.entity.Customer;
import by.it.chumak.jd02_01.entity.Good;
import by.it.chumak.jd02_01.entity.PriceListRepo;
import by.it.chumak.jd02_01.helper.RandomGenerator;
import by.it.chumak.jd02_01.helper.Timeout;

import java.util.Optional;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

    private final Customer customer;
    private final PriceListRepo priceList;

    public CustomerWorker(Customer customer, PriceListRepo priceList) {
        this.customer = customer;
        this.priceList = priceList;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();

        Good good = chooseGood();
        System.out.println(customer + " choose " + good.getName() + " that costs " + good.getPrice() + "$");
        int countGoods = putToCart(good);

        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good");
        oversleep(500, 2000);

        Optional<String> goodsName = priceList.getPriceList().keySet().stream().findAny();
        Good good = new Good(customer, goodsName.get(), priceList.getPriceList().get(goodsName.get()));
        System.out.println(customer + " finished to choose good");

        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the Shop");
    }

    @Override
    public void takeCart() {
        oversleep(100, 300);
        System.out.println(customer + " took the shopping cart");
    }

    @Override
    public int putToCart(Good good) {
        oversleep(100, 300);
        System.out.println(customer + " put " + good.getName() + " to the shopping cart");

        return RandomGenerator.get(1, 5);
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }

    private void oversleep(int max) {
        int timeout = RandomGenerator.get(max);
        Timeout.sleep(timeout);
    }

}

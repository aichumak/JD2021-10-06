package by.it.astapchik.jd02_01.service;

import by.it._classwork_.jd02_02.helper.Timeout;
import by.it.astapchik.jd02_01.entity.Customer;
import by.it.astapchik.jd02_01.entity.Good;
import by.it.astapchik.jd02_01.entity.ShoppingCart;
import by.it.astapchik.jd02_01.helper.GenerateRandomNumbers;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private ShoppingCart shoppingCart;

    public CustomerWorker(Customer customer, ShoppingCart shoppingCart) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the shop.");
    }


    @Override
    public void takeCart() {
        int timeout = GenerateRandomNumbers.get(100, 300);
        Timeout.sleep(timeout );
        shoppingCart = new ShoppingCart();
        System.out.println(customer + " took a cart. ");
    }

    @Override
    public Good chooseGood() {
        Good good;
        System.out.println(customer + " is taking products.");
        int timeout = GenerateRandomNumbers.get(500, 2000);
        Timeout.sleep(timeout );
        good = PriceListRepo.selectGood();
        System.out.println(customer + " has chosen " + good);
        putToCart(good);
        System.out.println(customer + " finished choosing products.");
        return new Good();
    }

    @Override
    public int putToCart(Good good) {
        int timeout = GenerateRandomNumbers.get(100, 300);
        Timeout.sleep(timeout );
        int numberOfGoods = GenerateRandomNumbers.get(2, 5);
        shoppingCart.addToCart(good, numberOfGoods);
        System.out.println(customer + " took " + numberOfGoods + " goods into his shopping cart.");
        return numberOfGoods;
    }


    @Override
    public void goOut() {
        System.out.println(customer + " left the shop.");
    }
}

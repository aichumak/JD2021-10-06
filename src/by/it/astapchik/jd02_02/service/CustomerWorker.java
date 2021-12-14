package by.it.astapchik.jd02_02.service;

import by.it.astapchik.jd02_02.helper.Timeout;
import by.it.astapchik.jd02_02.entity.Customer;
import by.it.astapchik.jd02_02.entity.Good;
import by.it.astapchik.jd02_02.entity.ShoppingCart;
import by.it.astapchik.jd02_02.entity.Store;
import by.it.astapchik.jd02_02.helper.GenerateRandomNumbers;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;
    private ShoppingCart shoppingCart;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        store.getManager().addCustomer();
        enteredStore();
        takeCart();
        chooseGood();
        goToQueue();
        goOut();
        store.getManager().removeCustomer();
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
        by.it._classwork_.jd02_02.entity.Good good;
        System.out.println(customer + " is taking products.");
        int timeout = GenerateRandomNumbers.get(500, 2000);
        Timeout.sleep(timeout );
        good = PriceListRepo.selectGood();
        System.out.println(customer + " has chosen " + good);
        customer.setTotal(good.getPrice());
        putToCart(good);
        System.out.println(customer + " finished choosing products.");
        return new Good();
    }

    @Override
    public int putToCart(by.it._classwork_.jd02_02.entity.Good good) {
        int timeout = GenerateRandomNumbers.get(100, 300);
        Timeout.sleep(timeout );
        int numberOfGoods = GenerateRandomNumbers.get(2, 5);
        shoppingCart.addToCart(good, numberOfGoods);
        System.out.println(customer + " took " + numberOfGoods + " goods into his shopping cart.");
        return numberOfGoods;
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " in the queue. ");
        synchronized (customer.getMonitor()){
            store.getQueue().add(customer);
            customer.setFlagWait(true);
            try {
                while (customer.isFlagWait()){
                    customer.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the shop.");
    }


}

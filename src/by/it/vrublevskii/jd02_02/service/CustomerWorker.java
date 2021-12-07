package by.it.vrublevskii.jd02_02.service;

import by.it.vrublevskii.jd02_02.entity.Store;
import by.it.vrublevskii.jd02_02.entity.Customer;
import by.it.vrublevskii.jd02_02.entity.Good;
import by.it.vrublevskii.jd02_02.entity.PriceListRepo;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Store store;
    private final Customer customer;
    private final PriceListRepo priceListRepo;
    private int goodsInCard = 0;

    public CustomerWorker(Store store, Customer customer, PriceListRepo priceListRepo) {
        this.store = store;
        this.customer = customer;
        this.priceListRepo = priceListRepo;
        store.getManager().addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int customerNeedsGoods;
        if (customer.getType().equals("Student")){
            customerNeedsGoods = RandomGenerator.get(0, 2);
        }else{
            customerNeedsGoods = RandomGenerator.get(2, 5);
        }
        if (customerNeedsGoods != 0){
            for (int j = 0; j < customerNeedsGoods; j++) {
                Good good = chooseGood();
                putToCart(good);
            }
        }
        goToQueue();
        goOut();
        store.getManager().finishCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the store");
    }

    @Override
    public void takeCart() {
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")){
            coefficient = 1.5;
        }
        int timeout = (int)(RandomGenerator.get(100, 300) * coefficient);
        Timeout.sleep(timeout);
        System.out.println(customer + " takes a cart");
    }

    @Override
    public Good chooseGood() {
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")){
            coefficient = 1.5;
        }
        System.out.println(customer + " is choosing goods");
        int timeout = (int)(RandomGenerator.get(500, 2000) * coefficient);
        Timeout.sleep(timeout);
        int index = RandomGenerator.get(0, 10);
        Good good = new Good(priceListRepo.getGoodName(index), priceListRepo.getGoodPrice(index));
        System.out.println(customer + " chose " + good);
        return good;
    }

    @Override
    public int putToCart(Good good) {
        goodsInCard++;
        double coefficient = 1;
        if (customer.getType().equals("Pensioner")){
            coefficient = 1.5;
        }
        int timeout = (int)(RandomGenerator.get(100, 300) * coefficient);
        Timeout.sleep(timeout);
        System.out.println(customer + " puts " + good + " in the cart");
        System.out.println("Goods in the cart total: " + goodsInCard);
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
        System.out.println(customer + " goes to queue");
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the store");
    }


}

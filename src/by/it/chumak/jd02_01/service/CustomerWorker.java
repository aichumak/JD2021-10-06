package by.it.chumak.jd02_01.service;

import by.it.chumak.jd02_01.entity.*;
import by.it.chumak.jd02_01.helper.RandomGenerator;
import by.it.chumak.jd02_01.helper.Timeout;

import java.util.Optional;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

    private final Customer customer;
    private final PriceListRepo priceList;
    private final CustomersCountRepo customersCountRepo;

    public CustomerWorker(Customer customer, CustomersCountRepo customersCountRepo, PriceListRepo priceList) {
        this.customer = customer;
        this.priceList = priceList;
        this.customersCountRepo = customersCountRepo;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        Good good = chooseGood();
        System.out.printf("%s choose %s that costs $%.2f%n", customer, good.getName(), good.getPrice());
        customer.setTotal(customer.getTotal() + (putToCart(good) * good.getPrice()));
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

        Optional<String> foundGood = priceList.getPriceList().keySet().stream().findAny();

        if (foundGood.isPresent()) {
            System.out.println(customer + " finished to choose good");
            return new Good(foundGood.get(), priceList.getPriceList().get(foundGood.get()));
        } else {
            return new Good();
        }
    }

    @Override
    public void goOut() {
        customersCountRepo.removeCustomer();
        System.out.printf("%s bought goods for a total of $%.2f and leaves the Shop%n", customer, customer.getTotal());
    }

    @Override
    public void takeCart() {
        if (customer.getCustomerType() == CustomerType.Pensioner) {
            oversleep(150, 450);
        } else {
            oversleep(100, 300);
        }
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
                goodsQuantity = RandomGenerator.get(0, 2);
            } else {
                goodsQuantity = RandomGenerator.get(1, 5);
            }
        }
        System.out.printf("%s put %s to the shopping cart%n", customer, good.getName());

        return goodsQuantity;
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }

}

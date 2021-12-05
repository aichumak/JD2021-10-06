package by.it.drankevich.jd02_03.service;

import by.it.drankevich.jd02_03.entity.*;
import by.it.drankevich.jd02_03.helper.RandomGenerator;
import by.it.drankevich.jd02_03.helper.Timeout;

import java.util.ArrayList;
import java.util.concurrent.*;

public class StoreWorker extends Thread {

    private final Store store;


    public StoreWorker(Store store) {
        this.store = store;

    }
   Semaphore semaphoreShoppingCart=new Semaphore(50);
    Semaphore semaphore=new Semaphore(20);




    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        int second = 0;


        ExecutorService threadPool= Executors.newFixedThreadPool(5);
        for (int numberCashier = 1; numberCashier <= 5; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            threadPool.execute(cashierWorker);

        }
        threadPool.shutdown();


        while (store.getManager().isOpenedStore()) {

            if (second > 60) {
                second = second - 60;
            }

            int count = numberOfPeople(second, store.getManager().customersInStore());
            second++;


            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {

                Customer customer;
                ShoppingCart shoppingCart = new ShoppingCart();

                int randomCustomer = RandomGenerator.get(1, 4);
                if (randomCustomer == 4) {
                    customer = new Pensioner(++customerCounter,shoppingCart);
                } else {
                    if (randomCustomer == 2 || randomCustomer == 3) {
                        customer = new Student(++customerCounter,shoppingCart);

                    } else {
                        customer = new Customer(++customerCounter,shoppingCart);
                    }

                }


                CustomerWorker customerWorker = new CustomerWorker(customer, store, shoppingCart,semaphore,semaphoreShoppingCart);
                customerWorker.start();
                Timeout.sleep(1000);


            }


        }
        try {
            threadPool.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Store closed");
    }

    private int numberOfPeople(int second, int numberPeople) {

        int count = 0;

        if (second == 0) {
            return count = RandomGenerator.get(20);
        }


        if (second <= 30 && numberPeople < (second + 10)) {
            count = RandomGenerator.get(((second + 10) - numberPeople) * 2);
            return count;
        }

        if (second > 30 && numberPeople <= (40 + (30 - second))) {
            count = RandomGenerator.get(((40 + (30 - second)) - numberPeople) * 2);
            return count;
        }

        return count;
    }
}

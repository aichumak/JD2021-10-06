package by.it.drankevich.jd02_02.service;

import by.it.drankevich.jd02_02.entity.*;
import by.it.drankevich.jd02_02.helper.RandomGenerator;
import by.it.drankevich.jd02_02.helper.Timeout;

import java.util.ArrayList;

public class StoreWorker extends Thread {

    public static final Integer monitorNumberPeopleInStore = 0;
    public static volatile Integer numberPeopleInStore = 0;
    private final Store store;


    public StoreWorker(Store store) {
        this.store = store;

    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        int second = 0;


        ArrayList<Thread> threads = new ArrayList<>();
        for (int numberCashier = 1; numberCashier <= 5; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();

        }

        while (store.getManager().isOpenedStore()) {
            second++;

            int count = numberOfPeople(second, numberPeopleInStore);
            synchronized (monitorNumberPeopleInStore) {
                numberPeopleInStore = numberPeopleInStore + count;
            }


            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {

                Customer customer;

                int randomCustomer = RandomGenerator.get(1, 4);
                if (randomCustomer == 4) {
                    customer = new Pensioner(++customerCounter);
                } else {
                    if (randomCustomer == 2 || randomCustomer == 3) {
                        customer = new Student(++customerCounter);

                    } else {
                        customer = new Customer(++customerCounter);
                    }

                }
                ShoppingCart shoppingCart = new ShoppingCart();
                CustomerWorker customerWorker = new CustomerWorker(customer, store, shoppingCart);
                customerWorker.start();
                Timeout.sleep(1000);


            }


        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        System.out.println("Store closed");
    }

    private int numberOfPeople(int second, int numberPeople) {

        int count = 0;

        if (second == 0) {
            return count = RandomGenerator.get(20);
        }


        if (second > 60) {
            second = second - 60;
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

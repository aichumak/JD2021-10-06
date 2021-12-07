package by.it.vrublevskii.jd02_02.service;

import by.it.vrublevskii.jd02_02.entity.*;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

import java.util.ArrayList;

public class StoreWorker extends Thread {

    private final Store store;
    private final Customer customer;

    public StoreWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void run() {
        System.out.println("Store is open");
        int customerCounter = 0;
        ArrayList<Thread> threads = new ArrayList<>();
//        Manager manager = new Manager(100);
//        Queue queue = new Queue();
//        Store store = new Store(manager, queue);
        PriceListRepo priceListRepo = new PriceListRepo();
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (store.getManager().isStoreOpen()) {
            int count = RandomGenerator.get(2);
            for (int i = 0; store.getManager().isStoreOpen() && i < count; i++) {
                Customer customer;
                int customerType = RandomGenerator.get(3);
                if (customerType == 0) {
                    customer = new Customer("Pensioner", ++customerCounter);
                } else if (customerType == 1 || customerType == 2) {
                    customer = new Customer("Student", ++customerCounter);
                } else {
                    customer = new Customer(++customerCounter);
                }
                CustomerWorker customerWorker = new CustomerWorker(store, customer, priceListRepo);
                threads.add(customerWorker);
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
        System.out.println("Store is closed");
    }
}

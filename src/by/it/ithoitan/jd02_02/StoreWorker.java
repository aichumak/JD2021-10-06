package by.it.ithoitan.jd02_02;


import by.it.ithoitan.jd02_02.entity.Cashier;
import by.it.ithoitan.jd02_02.entity.Customer;
import by.it.ithoitan.jd02_02.entity.Store;
import by.it.ithoitan.jd02_02.helper.RandomGenerator;

import by.it.ithoitan.jd02_02.helper.TimeOut;
import by.it.ithoitan.jd02_02.service.CashierWorker;
import by.it.ithoitan.jd02_02.service.CustomerWorker;

import java.util.ArrayList;

public class StoreWorker extends Thread {
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        ArrayList<Thread> threads = new ArrayList<>();
//        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();
        for (int numberCasier = 1; numberCasier <= 2; numberCasier++) {
            Cashier cashier = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (store.getManager().isOpenStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0; store.getManager().isOpenStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                TimeOut.sleep(1000);
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
}


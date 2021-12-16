package by.it.ithoitan.jd02_03;


import by.it.ithoitan.jd02_03.entity.Cashier;
import by.it.ithoitan.jd02_03.entity.Customer;
import by.it.ithoitan.jd02_03.entity.Store;
import by.it.ithoitan.jd02_03.helper.RandomGenerator;
import by.it.ithoitan.jd02_03.helper.TimeOut;
import by.it.ithoitan.jd02_03.service.CashierWorker;
import by.it.ithoitan.jd02_03.service.CustomerWorker;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();
        for (int numberCasier = 1; numberCasier <= 2; numberCasier++) {
            Cashier cashier = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            threadPool.execute(cashierWorker);
        }
        threadPool.shutdown();
        while (store.getManager().isOpenStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0; store.getManager().isOpenStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                TimeOut.sleep(1000);
            }
        }
        try {
            threadPool.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Store closed");
    }
}


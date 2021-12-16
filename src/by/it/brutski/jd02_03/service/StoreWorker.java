package by.it.brutski.jd02_03.service;

import by.it.brutski.jd02_03.entity.Cashier;
import by.it.brutski.jd02_03.entity.Customer;
import by.it.brutski.jd02_03.entity.Store;
import by.it.brutski.jd02_03.helper.RandomGenerator;
import by.it.brutski.jd02_03.helper.TimeOut;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread{
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int counter = 0;  //счетчик

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            threadPool.execute(cashierWorker);
        }

        threadPool.shutdown();
        while (store.getManager().isOpenedStore()) {
            int count = RandomGenerator.get(0, 2);

            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
                Customer customer = new Customer(++counter);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
                TimeOut.sleep(1000);
            }
        }
        try {
            //noinspection StatementWithEmptyBody
            threadPool.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");
    }
}

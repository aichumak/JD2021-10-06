package by.it.laevskiy.jd02_03.service;

import by.it.laevskiy.jd02_03.entity.Cashier;
import by.it.laevskiy.jd02_03.entity.Customer;
import by.it.laevskiy.jd02_03.entity.Store;
import by.it.laevskiy.jd02_03.helper.RandomGenerator;
import by.it.laevskiy.jd02_03.helper.Timeout;
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

        for (int numberCasier = 1; numberCasier <= 2; numberCasier++) {
            Cashier cashier = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            threadPool.execute(cashierWorker);
        }
        threadPool.shutdown();

        while (store.getManager().isOpenedStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
                Timeout.sleep(1000);
            }

        }
        try {
            //noinspection ResultOfMethodCallIgnored
            threadPool.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Store closed");
    }
}

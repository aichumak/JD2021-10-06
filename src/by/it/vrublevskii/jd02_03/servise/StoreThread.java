package by.it.vrublevskii.jd02_03.servise;


import by.it.vrublevskii.jd02_03.entity.Cashier;
import by.it.vrublevskii.jd02_03.entity.Customer;
import by.it.vrublevskii.jd02_03.entity.PriceListRepo;
import by.it.vrublevskii.jd02_03.entity.Store;
import by.it.vrublevskii.jd02_03.helper.CustomerGenerator;
import by.it.vrublevskii.jd02_03.helper.RandomGenerator;
import by.it.vrublevskii.jd02_03.helper.Timeout;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreThread extends Thread {

    private final Store store;

    public StoreThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        PriceListRepo priceListRepo = new PriceListRepo();
        System.out.println("Store is opened");
        int customerCounter = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int numberCashier = 1; numberCashier <=2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierThread cashierThread = new CashierThread(store, cashier);
            threadPool.execute(cashierThread);
        }
        threadPool.shutdown();
        while (store.getManager().isStoreOpen()) {
            int customersInSecond = RandomGenerator.get(2);
            for (int i = 0; store.getManager().isStoreOpen() && i < customersInSecond; i++) {
                Customer customer = CustomerGenerator.get(++customerCounter);
                CustomerThread customerThread = new CustomerThread(store, customer, priceListRepo);
                customerThread.start();
                Timeout.sleep(1000);
            }
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            threadPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store is closed");
    }
}

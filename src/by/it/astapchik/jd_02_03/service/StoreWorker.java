package by.it.astapchik.jd_02_03.service;

import by.it.astapchik.jd_02_03.entity.Cashier;
import by.it.astapchik.jd_02_03.entity.Customer;
import by.it.astapchik.jd_02_03.entity.Store;
import by.it.astapchik.jd_02_03.helper.GenerateRandomNumbers;
import by.it.astapchik.jd_02_03.helper.Timeout;

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
        System.out.println("Store is opened.");
        int customerCounter = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            executorService.execute(cashierWorker);
        }
        executorService.shutdown();

        while (store.getManager().isOpenedStore()){
            int count = GenerateRandomNumbers.get(0, 2);
            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
                Timeout.sleep(1000);
            }
        }
        try {
            while(!executorService.awaitTermination(1000, TimeUnit.MICROSECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store is closed.");
    }
}

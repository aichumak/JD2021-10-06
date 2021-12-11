package by.it.laevskiy.jd02_02.service;

import by.it.laevskiy.jd02_02.entity.Cashier;
import by.it.laevskiy.jd02_02.entity.Customer;
import by.it.laevskiy.jd02_02.entity.Store;
import by.it.laevskiy.jd02_02.helper.RandomGenerator;
import by.it.laevskiy.jd02_02.helper.Timeout;

import java.util.ArrayList;
import java.util.List;

public class StoreWorker extends Thread {
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        List<Thread> threads = new ArrayList<>();

        for (int numberCasier = 1; numberCasier <=2 ; numberCasier++) {
            Cashier cashier = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        while (store.getManager().isOpenedStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0;store.getManager().isOpenedStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(store,customer);
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
        System.out.println("Store closed");
    }
}

package by.it.astapchik.jd_02_02.service;

import by.it.astapchik.jd_02_02.entity.Cashier;
import by.it.astapchik.jd_02_02.entity.Customer;
import by.it.astapchik.jd_02_02.entity.Store;
import by.it.astapchik.jd_02_02.helper.GenerateRandomNumbers;
import by.it.astapchik.jd_02_02.helper.Timeout;

import java.util.ArrayList;

public class StoreWorker extends Thread{

    private final Store store;
    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store is opened.");
        int customerCounter = 0;

        ArrayList<Thread> threads = new ArrayList<>();

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();

        }

        while (store.getManager().isOpenedStore()){
            int count = GenerateRandomNumbers.get(0, 2);
            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                threads.add(customerWorker);
                customerWorker.start();
                Timeout.sleep(1000);
            }
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Store is closed.");
    }
}

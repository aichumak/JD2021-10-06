package by.it.konon.jd02_03.service;

import by.it.konon.jd02_03.entity.Cashier;
import by.it.konon.jd02_03.entity.Customer;
import by.it.konon.jd02_03.entity.CustomerKind;
import by.it.konon.jd02_03.entity.Store;
import by.it.konon.jd02_03.helper.RandomGenerator;
import by.it.konon.jd02_03.helper.Timeout;

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
        int customerCouner = 0;

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            newFixedThreadPool.execute(cashierWorker);
        }
        newFixedThreadPool.shutdown();
        while (store.getManager().isOpenedStore()) {
            createAndStartCustomers(store);
        }
        try {
            //noinspection StatementWithEmptyBody
            while(!newFixedThreadPool.awaitTermination(1000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Store closed");
    }


    private void createAndStartCustomers(Store store) {
        CustomerKind customerKind;
        int customerTypeCounter = 0;
        int customerCount = 0;

        while (store.getManager().isOpenedStore()) {
            for (int minute = 1; minute < 3; minute++) {
                for (int second = 1; second <= 60; second++) {
                    int randomCustomersCount = getRandomNumber(second, store.getManager().numberCustomersInStore());
                    for (int i = 0; store.getManager().isOpenedStore() && i < randomCustomersCount; i++) {
                        customerTypeCounter++;
                            customerKind = CustomerKind.Customer;
                        createAndStartCustomer(store, ++customerCount, customerKind);

                    }
                }

            }

        }

    }



    private int getRandomNumber(int second, int countCustomersInStore) {
        if (second <= 30) {
            return RandomGenerator.get(second + 10 - 1 - countCustomersInStore);
        } else {
            return RandomGenerator.get(40 + 30 - second - 1 - countCustomersInStore);
        }

    }


    private void createAndStartCustomer(Store store, int customerNumber, CustomerKind customerKind) {
        Customer customer = new Customer(customerNumber, customerKind);
        CustomerWorker customerWorker = new CustomerWorker(customer, store);
        customerWorker.start();
        Timeout.sleep(1000);


    }



}

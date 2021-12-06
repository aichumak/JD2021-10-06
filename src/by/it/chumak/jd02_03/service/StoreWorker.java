package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Cashier;
import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.CustomerType;
import by.it.chumak.jd02_03.entity.Store;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {

    private final Store STORE;

    public StoreWorker(Store store) {
        this.STORE = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");

        ExecutorService executorService = Executors.newFixedThreadPool(STORE.getManager().getCashiersMaxCount());
        for (int numberCashier = 1; numberCashier <= STORE.getManager().getCashiersMaxCount(); numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(STORE, cashier);
            executorService.execute(cashierWorker);
        }
        executorService.shutdown();

        while (STORE.getManager().isOpenedStore()) {
            createAndStartCustomers(STORE);
        }

        try {
            //noinspection ResultOfMethodCallIgnored
            executorService.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");

    }

    private void createAndStartCustomers(Store store) {
        CustomerType customerType;
        int customerTypeCounter = 0;
        int customerCount = 0;

        while (store.getManager().isOpenedStore()) {
            for (int minute = 1; minute < 3; minute++) {
                for (int second = 1; second <= 60; second++) {
                    int randomCustomersCount = getRandomNumber(second, store.getManager().numberCustomersInStore());
                    for (int i = 0; store.getManager().isOpenedStore() && i < randomCustomersCount; i++) {
                        customerTypeCounter++;
                        if (customerTypeCounter == 2) {
                            customerType = CustomerType.Student;
                        } else if (customerTypeCounter == 4) {
                            customerType = CustomerType.Pensioner;
                            customerTypeCounter = 0;
                        } else {
                            customerType = CustomerType.Customer;
                        }
                        createAndStartCustomer(store, ++customerCount, customerType);
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

    private void createAndStartCustomer(Store store, int customerNumber, CustomerType customerType) {
        Customer customer = new Customer(customerNumber, customerType);
        CustomerWorker customerWorker = new CustomerWorker(customer, store);

        if (customerType == CustomerType.Pensioner) {
            Timeout.sleep(1500);
        } else {
            Timeout.sleep(1000);
        }

        customerWorker.start();
    }

}

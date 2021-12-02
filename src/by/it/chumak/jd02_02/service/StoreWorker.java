package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.*;
import by.it.chumak.jd02_02.helper.RandomGenerator;
import by.it.chumak.jd02_02.helper.Timeout;

import java.util.ArrayList;

public class StoreWorker extends Thread {

    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        ArrayList<Thread> threads = new ArrayList<>();

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(store, cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        while (store.getManager().isOpenedStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
                createAndStartCustomers(store);
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

    private void createAndStartCustomers(Store store) {
        CustomerType customerType;
        int customerTypeCounter = 0;
        int customerCount = 0;
       // int randomCustomersCount = getRandomNumber(second, customersCount);

        while (store.getManager().isOpenedStore()) {
            int count = RandomGenerator.get(0, 2);
            for (int i = 0; store.getManager().isOpenedStore() && i < count; i++) {
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

    private int getRandomNumber(int second, CustomersCountRepo customersCount) {
        if (second <= 30) {
            return RandomGenerator.get(second + 10 - 1 - customersCount.getCustomersCount());
        } else {
            return RandomGenerator.get(40 + 30 - second - 1 - customersCount.getCustomersCount());
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

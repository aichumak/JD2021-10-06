package by.it.chumak.jd02_01;

import by.it.chumak.jd02_01.entity.Customer;
import by.it.chumak.jd02_01.entity.CustomerType;
import by.it.chumak.jd02_01.entity.CustomersCountRepo;
import by.it.chumak.jd02_01.helper.PriceListRepo;
import by.it.chumak.jd02_01.helper.RandomGenerator;
import by.it.chumak.jd02_01.helper.Timeout;
import by.it.chumak.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread {
    int customerNumber = 0;

    @Override
    public void run() {
        PriceListRepo priceListRepo = new PriceListRepo();
        CustomersCountRepo customersCount = new CustomersCountRepo(0);

        System.out.println("Store opened");

        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();

        for (int minute = 1; minute < 3; minute++) {
            for (int second = 1; second <= 60; second++) {
                createAndStartCustomers(second, customersCount, priceListRepo, customerWorkers);
            }
        }

        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Store closed, count of customers in the store: %d", customersCount.getCustomersCount());
    }

    private void createAndStartCustomers(int second, CustomersCountRepo customersCount, PriceListRepo priceListRepo, ArrayList<CustomerWorker> customerWorkers) {
        int customerTypeCounter = 0;
        int randomCustomersCount = getRandomNumber(second, customersCount);

        for (int i = 0; i < randomCustomersCount; i++) {
            CustomerType customerType;
            customerTypeCounter++;
            customerNumber++;

            if (customerTypeCounter == 2) {
                customerType = CustomerType.Student;
            } else if (customerTypeCounter == 4) {
                customerType = CustomerType.Pensioner;
                customerTypeCounter = 0;
            } else {
                customerType = CustomerType.Customer;
            }

            createCustomer(customersCount, priceListRepo, customerWorkers, customerType);
            System.out.printf("=========== second: %d, count of customers in the store: %d%n", second, customersCount.getCustomersCount());
        }
    }

    private int getRandomNumber(int second, CustomersCountRepo customersCount) {
        if (second <= 30) {
            return RandomGenerator.get(second + 10 - 1 - customersCount.getCustomersCount());
        } else {
            return RandomGenerator.get(40 + 30 - second - 1 - customersCount.getCustomersCount());
        }
    }

    private void createCustomer(CustomersCountRepo customersCount, PriceListRepo priceListRepo, ArrayList<CustomerWorker> customerWorkers, CustomerType customerType) {
        Customer customer = new Customer(customerNumber, customerType);
        CustomerWorker customerWorker = new CustomerWorker(customer, customersCount, priceListRepo);
        customerWorkers.add(customerWorker);
        customersCount.addCustomer();
        customerWorker.start();

        if (customerType == CustomerType.Pensioner) {
            Timeout.sleep(1500);
        } else {
            Timeout.sleep(1000);
        }
    }

}

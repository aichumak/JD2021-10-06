package by.it.chumak.jd02_01;

import by.it.chumak.jd02_01.entity.Customer;
import by.it.chumak.jd02_01.entity.CustomerType;
import by.it.chumak.jd02_01.entity.CustomersCountRepo;
import by.it.chumak.jd02_01.entity.PriceListRepo;
import by.it.chumak.jd02_01.helper.RandomGenerator;
import by.it.chumak.jd02_01.helper.Timeout;
import by.it.chumak.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread {
    @Override
    public void run() {
        int customerTypeCounter = 0;
        int customerNumber = 0;
        PriceListRepo priceListRepo = new PriceListRepo();
        CustomersCountRepo customersCount = new CustomersCountRepo(0);

        System.out.println("Store opened");

        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();

        for (int minute = 1; minute < 3; minute++) {
            for (int second = 1; second <= 30; second++) {
                CustomerType customerType;
                int randomCustomersCount = RandomGenerator.get(second + 10 - 1 - customersCount.getCustomersCount());
                for (int i = 0; i < randomCustomersCount; i++) {
                    //while (customersCount.getCustomersCount() < (second + 10)) {

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
                    createCustomer(customersCount, customerNumber, priceListRepo, customerWorkers, customerType);
                    System.out.println("//////////////////// second: " + second + ", count: " + customersCount.getCustomersCount());
                }
                //startCustomersWorkers(customerWorkersList);
            }

            for (int second = 30; second <= 60; second++) {
                CustomerType customerType;
                int randomCustomersCount = RandomGenerator.get(40 + 30 - second - 1 - customersCount.getCustomersCount());
                //while (customersCount.getCustomersCount() <= 40 + (30 - second)) {
                for (int i = 0; i < randomCustomersCount; i++) {
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
                    createCustomer(customersCount, customerNumber, priceListRepo, customerWorkers, customerType);
                    System.out.println("//////////////////// second: " + second + ", count: " + customersCount.getCustomersCount());
                }
                //startCustomersWorkers(customerWorkersList);
            }
        }

        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store closed, count customers: " + customersCount.getCustomersCount());
    }

    private void createCustomer(CustomersCountRepo customersCount, int customerNumber, PriceListRepo priceListRepo, ArrayList<CustomerWorker> customerWorkers, CustomerType customerType) {
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

package by.it.konon.jd02_01;

import by.it.konon.jd02_01.entity.Customer;
import by.it.konon.jd02_01.entity.CustomerKind;
import by.it.konon.jd02_01.entity.CustomerCount;
import by.it.konon.jd02_01.helper.PriceListRepo;
import by.it.konon.jd02_01.helper.Timeout;
import by.it.konon.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread {
    int customerNumber = 0;

    @Override
    public void run() {
        PriceListRepo priceListRepo = new PriceListRepo();
        CustomerCount customersCount = new CustomerCount(0);

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

    private void createAndStartCustomers(int second, CustomerCount customersCount, PriceListRepo priceListRepo, ArrayList<CustomerWorker> customerWorkers) {
        int customerTypeCounter = 0;


        for (int i = 0; i < 10; i++) {
            CustomerKind customerType;
            customerTypeCounter++;
            customerNumber++;
            customerType = CustomerKind.Customer;


            createCustomer(customersCount, priceListRepo, customerWorkers, customerType);

        }
    }



    private void createCustomer(CustomerCount customersCount, PriceListRepo priceListRepo, ArrayList<CustomerWorker> customerWorkers, CustomerKind customerType) {
        Customer customer = new Customer(customerNumber, customerType);
        CustomerWorker customerWorker = new CustomerWorker(customer, customersCount, priceListRepo);
        customerWorkers.add(customerWorker);
        customersCount.addCustomer();
        customerWorker.start();

        Timeout.sleep(100);
        }
    }



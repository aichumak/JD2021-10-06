package by.it.vrublevskii.jd02_01.old;

import by.it.vrublevskii.jd02_01.old.entity.Customer;
import by.it.vrublevskii.jd02_01.old.entity.PriceListRepo;
import by.it.vrublevskii.jd02_01.old.helper.RandomGenerator;
import by.it.vrublevskii.jd02_01.old.helper.Timeout;
import by.it.vrublevskii.jd02_01.old.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread {
    @Override
    public void run() {
        System.out.println("Store is open");
        int customerCounter = 0;
        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();
        PriceListRepo priceListRepo = new PriceListRepo();
        for (int second = 0; second < 120; second++) {
            int count = RandomGenerator.get(2);
            for (int i = 0; i < count; i++) {
                Customer customer;
                int customerType = RandomGenerator.get(3);
                if (customerType == 0) {
                    customer = new Customer("Pensioner", ++customerCounter);
                } else if (customerType == 1 || customerType == 2) {
                    customer = new Customer("Student", ++customerCounter);
                } else {
                    customer = new Customer(++customerCounter);
                }
                CustomerWorker customerWorker = new CustomerWorker(customer, priceListRepo);
                customerWorkers.add(customerWorker);
                customerWorker.start();
                Timeout.sleep(1000);
            }
        }

        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store is closed");
    }
}

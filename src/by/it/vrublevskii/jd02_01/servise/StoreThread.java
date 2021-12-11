package by.it.vrublevskii.jd02_01.servise;


import by.it.vrublevskii.jd02_01.entity.Customer;
import by.it.vrublevskii.jd02_01.entity.PriceListRepo;
import by.it.vrublevskii.jd02_01.helper.CustomerGenerator;
import by.it.vrublevskii.jd02_01.helper.NumberCustomersInStore;
import by.it.vrublevskii.jd02_01.helper.RandomGenerator;
import by.it.vrublevskii.jd02_01.helper.Timeout;

import java.util.ArrayList;

public class StoreThread extends Thread {

    @Override
    public void run() {
        PriceListRepo priceListRepo = new PriceListRepo();
        ArrayList<CustomerThread> customerThreads = new ArrayList<>();
        System.out.println("Store is opened");
        int customerCounter = 0;
        int seconds;
        for (seconds = 0; seconds < 120; seconds++) {
//            int maxInCustomers = 20 + seconds * 2;





            int customersInSecond = RandomGenerator.get(0, 2);
            for (int i = 0; i < customersInSecond; i++) {
                customerCounter++;
                Customer customer = CustomerGenerator.get(customerCounter);
                CustomerThread customerThread = new CustomerThread(customer, priceListRepo);
                customerThreads.add(customerThread);
                customerThread.start();
            }
            Timeout.sleep(1000);
            System.out.printf("%n%nCustomers in store (second: %d): %d%n%n%n", seconds, NumberCustomersInStore.get());
        }
        for (CustomerThread customerThread : customerThreads) {
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store is closed");
    }
}

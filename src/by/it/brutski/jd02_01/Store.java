package by.it.brutski.jd02_01;

import by.it.brutski.jd02_01.entity.Customer;
import by.it.brutski.jd02_01.helper.RandomGenerator;
import by.it.brutski.jd02_01.helper.TimeOut;
import by.it.brutski.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread{

    @Override
    public void run() {
        System.out.println("Store opened");
        int counter = 0;  //счетчик

        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();
        for (int second = 0; second < 120; second++) {
            int count = RandomGenerator.get(0, 2);

            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++counter);

                CustomerWorker customerWorker = new CustomerWorker(customer);
                customerWorkers.add(customerWorker);

                customerWorker.start();
                TimeOut.sleep(1000);
            }
        }
        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store closed");
    }
}

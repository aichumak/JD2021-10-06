package by.it.astapchik.jd02_01;

import by.it.astapchik.jd02_01.entity.Customer;
import by.it.astapchik.jd02_01.entity.ShoppingCart;
import by.it.astapchik.jd02_01.helper.GenerateRandomNumbers;
import by.it.astapchik.jd02_01.helper.Timeout;
import by.it.astapchik.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread{
    @Override
    public void run() {
        System.out.println("Store is opened.");
        int customerCounter = 0;

        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();
        for (int sec = 0; sec <  120; sec++) {
            int count = new GenerateRandomNumbers().get(0, 2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++customerCounter);
                ShoppingCart shoppingCart = new ShoppingCart();
                CustomerWorker customerWorker = new CustomerWorker(customer, shoppingCart);
                customerWorkers.add(customerWorker);
                customerWorker.start();
                Timeout.sleep(1000);
            }
        }
        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Store is closed.");
    }
}

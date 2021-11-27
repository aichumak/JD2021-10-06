package by.it.ithoitan.jd02_02;

import by.it.ithoitan.jd02_02.entity.Customer;
import by.it.ithoitan.jd02_02.helper.RandomGenerator;
import by.it.ithoitan.jd02_02.service.CustomerWorker;

public class Store extends Thread {
    @Override
    public void run(){
        System.out.println("Store opened");
        int customerCounter = 0;
        for (int second = 0; second < 120; second++) {
           int count = RandomGenerator.get(0,2);
            for (int i = 0; i < count; i++) {

            }
        }
        System.out.println("Store closed");
    }
}

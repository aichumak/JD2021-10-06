package by.it.drankevich.jd02_01;

import by.it.drankevich.jd02_01.entity.Customer;
import by.it.drankevich.jd02_01.entity.Pensioner;
import by.it.drankevich.jd02_01.entity.ShoppingCart;
import by.it.drankevich.jd02_01.entity.Student;
import by.it.drankevich.jd02_01.helper.RandomGenerator;
import by.it.drankevich.jd02_01.helper.Timeout;
import by.it.drankevich.jd02_01.service.CustomerWorker;

import java.util.ArrayList;

public class Store extends Thread {
    public static  int numberPeopleInStore;

    @Override
    public void run() {
        System.out.println("Store opened");
        int customerCounter = 0;
        numberPeopleInStore = 0;

        ArrayList<CustomerWorker> customerWorkers = new ArrayList<>();

        for (int second = 0; second < 120; second++) {

            int count = numberOfPeople(second, numberPeopleInStore);
            numberPeopleInStore = numberPeopleInStore + count;



            for (int i = 0; i < count; i++) {

                Customer customer;

                int randomCustomer = RandomGenerator.get(1, 4);
                if (randomCustomer == 4) {
                    customer = new Pensioner(++customerCounter);
                } else {
                    if (randomCustomer == 2 || randomCustomer == 3) {
                        customer = new Student(++customerCounter);

                    } else {
                        customer = new Customer(++customerCounter);
                    }

                }
                ShoppingCart shoppingCart = new ShoppingCart();
                CustomerWorker customerWorker = new CustomerWorker(customer, shoppingCart);
                customerWorkers.add(customerWorker);
                customerWorker.start();

            }
            Timeout.sleep(1000);


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

    private int numberOfPeople(int second, int numberPeople) {

        int count = 0;

        if (second == 0) {
            return count = RandomGenerator.get(20);
        }

        if (second == 120) {
            return count;
        }

        if (second > 60) {
            second = second - 60;
        }

        if (second <= 30 && numberPeople < (second + 10)) {
            count = RandomGenerator.get(((second + 10) - numberPeople) * 2);
            return count;
        }

        if (second > 30 && numberPeople <= (40 + (30 - second))) {
            count = RandomGenerator.get(((40 + (30 - second)) - numberPeople) * 2);
            return count;
        }

        return count;
    }
}

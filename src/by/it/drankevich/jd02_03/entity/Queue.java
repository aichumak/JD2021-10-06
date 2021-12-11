package by.it.drankevich.jd02_03.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {


    private final BlockingDeque<Customer> customerDeque;

    public Queue(int capasity) {customerDeque=new LinkedBlockingDeque<>(capasity);
    }


    public void addCustomer(Customer customer) {

        try {
            customerDeque.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Customer extract() {

            return customerDeque.pollFirst();

    }

    public Deque<Customer> getCustomerDeque() {
        return customerDeque;
    }
}

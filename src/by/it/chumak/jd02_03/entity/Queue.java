package by.it.chumak.jd02_03.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final BlockingDeque<Customer> customerDeque;

    public Queue(int capacity) {
        customerDeque = new LinkedBlockingDeque<>(capacity);
    }

    public void add(Customer customer) {
        try {
            customerDeque.putLast(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer extract() {
        return customerDeque.pollFirst();
    }

}

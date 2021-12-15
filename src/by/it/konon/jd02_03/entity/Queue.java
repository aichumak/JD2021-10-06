package by.it.konon.jd02_03.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {
    public final Object queue = new Object();
    private final BlockingDeque<Customer> deqCustomer;

    public Queue(int capacity) {
        deqCustomer = new LinkedBlockingDeque<>(capacity);

    }


    public void add(Customer customer) {
        try {
            deqCustomer.putLast(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer extract() {
        return this.deqCustomer.pollFirst();
    }


    public int getSize() {
        synchronized (this.queue) {
            return this.deqCustomer.size();
        }
    }
}

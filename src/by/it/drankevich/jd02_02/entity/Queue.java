package by.it.drankevich.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    private final Object queueMonitor = new Object();

    private final Deque<Customer> customerDeque = new ArrayDeque<>();

    public void addCustomer(Customer customer) {
        synchronized (queueMonitor) {
            customerDeque.addLast(customer);
        }
    }

    public Customer extract() {
        synchronized (queueMonitor) {
            return customerDeque.pollFirst();
        }
    }

}

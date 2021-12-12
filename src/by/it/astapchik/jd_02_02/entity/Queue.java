package by.it.astapchik.jd_02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    private final Deque<Customer> customerDeque = new ArrayDeque<>();
    public static final Object queueMonitor = new Object();

    public void add(Customer customer){
        synchronized (queueMonitor) {
            customerDeque.addLast(customer);
        }
    }

    public Customer extract(){
        return customerDeque.pollFirst();
    }
}

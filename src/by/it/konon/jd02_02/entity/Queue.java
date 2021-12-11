package by.it.konon.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

    public final Object queueMonitor = new Object();
    private final Deque<Customer> customerDeq = new ArrayDeque<>();

    public void add(Customer customer) {
        synchronized (this.queueMonitor) {
            this.customerDeq.addLast(customer);
        }
    }

    public Customer extract() {
        synchronized (this.queueMonitor) {
            return this.customerDeq.pollFirst();
        }
    }

    public int getSize() {
        synchronized (this.queueMonitor) {
            return this.customerDeq.size();
        }
    }
}

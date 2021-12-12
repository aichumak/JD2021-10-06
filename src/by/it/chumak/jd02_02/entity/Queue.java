package by.it.chumak.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

    public final Object QUEUE_MONITOR = new Object();
    private final Deque<Customer> CUSTOMER_DEQUEUE = new ArrayDeque<>();

    public void add(Customer customer) {
        synchronized (this.QUEUE_MONITOR) {
            this.CUSTOMER_DEQUEUE.addLast(customer);
        }
    }

    public Customer extract() {
        synchronized (this.QUEUE_MONITOR) {
            return this.CUSTOMER_DEQUEUE.pollFirst();
        }
    }

    public int getSize() {
        synchronized (this.QUEUE_MONITOR) {
            return this.CUSTOMER_DEQUEUE.size();
        }
    }
}

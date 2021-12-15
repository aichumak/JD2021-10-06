package by.it.konon.jd02_02;


import by.it.konon.jd02_02.entity.Customer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    public final Object queue = new Object();
    private final Deque<Customer> deqCustomer = new ArrayDeque<>();

    public void add(Customer customer) {
        synchronized (this.queue) {
            this.deqCustomer.addLast(customer);
        }
    }

    public Customer extract() {
        synchronized (this.queue) {
            return this.deqCustomer.pollFirst();
        }
    }

    public int getSize() {
        synchronized (this.queue) {
            return this.deqCustomer.size();
        }
    }
}

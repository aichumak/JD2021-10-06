package by.it.chumak.bank.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    public final Object QUEUE_MONITOR = new Object();
    private final Deque<Client> CUSTOMER_DEQUEUE = new ArrayDeque<>();

    public void add(Client client) {
        synchronized (this.QUEUE_MONITOR) {
            this.CUSTOMER_DEQUEUE.addLast(client);
        }
    }

    public Client extract() {
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

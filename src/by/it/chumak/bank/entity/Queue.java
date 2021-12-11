package by.it.chumak.bank.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final BlockingDeque<Client> clientDeque;

    public Queue(int capacity) {
        clientDeque = new LinkedBlockingDeque<>(capacity);
    }

    public void add(Client client) {
        try {
            clientDeque.putLast(client);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Client extract() {
        return clientDeque.pollFirst();
    }

    public int getSize() {
        return this.clientDeque.size();
    }
}

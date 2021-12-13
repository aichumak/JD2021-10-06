package by.it.drankevich.callcenter.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    public final BlockingDeque<Client> queue;

    public Queue() {
        this.queue = new LinkedBlockingDeque<>();
    }

    public boolean addQueue(Client client) {

        return queue.offerLast(client);
    }

    public Client extract() {

        return queue.pollFirst();

    }

    public BlockingDeque<Client> getQueue() {
        return queue;
    }
}

package by.it.chumak.jd02_02.entity;

import by.it.chumak.jd02_02.service.PriceListRepo;

public class Store {

    private final Manager manager;
    private final Queue queue;
    private final PriceListRepo storePriceList;


    public Store(Manager manager, Queue queue) {
        this.manager = manager;
        this.queue = queue;
        this.storePriceList = new PriceListRepo();
    }

    public Manager getManager() {
        return manager;
    }

    public Queue getQueue() {
        return queue;
    }

    public PriceListRepo getStorePriceList() {
        return storePriceList;
    }
}

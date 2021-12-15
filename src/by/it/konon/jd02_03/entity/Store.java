package by.it.konon.jd02_03.entity;

import by.it.konon.jd02_03.service.PriceListRepo;

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
        return this.manager;
    }

    public Queue getQueue() {
        return this.queue;
    }

    public PriceListRepo getStorePriceList() {
        return this.storePriceList;
    }
}

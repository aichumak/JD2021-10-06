package by.it.chumak.jd02_02.entity;

import by.it.chumak.jd02_02.service.PriceListRepo;

public class Store {

    private final Manager MANAGER;
    private final Queue QUEUE;
    private final PriceListRepo STORE_PRICE_LIST;


    public Store(Manager manager, Queue queue) {
        this.MANAGER = manager;
        this.QUEUE = queue;
        this.STORE_PRICE_LIST = new PriceListRepo();
    }

    public Manager getManager() {
        return this.MANAGER;
    }

    public Queue getQueue() {
        return this.QUEUE;
    }

    public PriceListRepo getStorePriceList() {
        return this.STORE_PRICE_LIST;
    }
}

package by.it.chumak.jd02_03.entity;

import by.it.chumak.jd02_03.service.PriceListRepo;

import java.util.concurrent.Semaphore;

public class Store {

    private final Manager MANAGER;
    private final Queue QUEUE;
    private final PriceListRepo STORE_PRICE_LIST;
    private final Semaphore SEMAPHORE;


    public Store(Manager manager, Queue queue, int permits) {
        this.MANAGER = manager;
        this.QUEUE = queue;
        this.STORE_PRICE_LIST = new PriceListRepo();
        this.SEMAPHORE = new Semaphore(permits);
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

    public Semaphore getSEMAPHORE() {
        return SEMAPHORE;
    }
}

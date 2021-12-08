package by.it.drankevich.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int PLAN;
    public AtomicInteger countInCustomer = new AtomicInteger(0);
    public AtomicInteger countOutCustomer = new AtomicInteger(0);

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

    public void addCustomer() {
        countInCustomer.getAndIncrement();
    }

    public void finishedCustomer() {
        countOutCustomer.getAndIncrement();
    }

    public boolean isOpenedStore() {
        return countInCustomer.get() != PLAN;
    }

    public boolean isClosedStore() {
        return countOutCustomer.get() == PLAN;
    }

    int customersInStore = 0;

    public int customersInStore() {
        return customersInStore = countInCustomer.get() - countOutCustomer.get();
    }

}


package by.it._classwork_.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int PLAN;
    private final AtomicInteger countInCustomer = new AtomicInteger(0);
    private final AtomicInteger countOutCustomer = new AtomicInteger(0);

    public Manager(int plan) {
        this.PLAN = plan;
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


}

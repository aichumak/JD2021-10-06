package by.it.serkutsyev.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int PLAN;
    private final AtomicInteger counterOutCustomer = new AtomicInteger();
    private final AtomicInteger counterInCustomer = new AtomicInteger();

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public void addCustomer() {
        counterInCustomer.getAndIncrement();

    }

    public void finishedCustomer() {
        counterOutCustomer.getAndIncrement();

    }

    public boolean isOpenedStore() {
        return counterInCustomer.get() != PLAN;
    }

    public boolean isClosedStore() {
        return counterOutCustomer.get() == PLAN;
    }
}

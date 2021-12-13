package by.it.vrublevskii.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int plan;
    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);

    public Manager(int plan) {
        this.plan = plan;
    }

    public int getPlan() {
        return plan;
    }

    public void addCustomer() {
        countCustomerIn.getAndIncrement();
    }

    public void terminateCustomer() {
        countCustomerOut.getAndIncrement();
    }

    public boolean isStoreOpen() {
        return countCustomerIn.get() != plan;
    }

    public boolean isStoreClosed() {
        return countCustomerOut.get() == plan;
    }

}

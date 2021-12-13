package by.it.konon.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int PLAN;
    private final AtomicInteger countInCustomer = new AtomicInteger(0);
    private final AtomicInteger countOutCustomer = new AtomicInteger(0);


    public Manager(int plan) {
        this.PLAN = plan;

    }



    public synchronized void addCustomer() {
        this.countInCustomer.getAndIncrement();
    }

    public synchronized void finishedCustomer() {
        this.countOutCustomer.getAndIncrement();
    }

    public boolean isOpenedStore() {
        return this.countInCustomer.get() != this.PLAN;
    }

    public boolean isClosedStore() {
        return this.countOutCustomer.get() == this.PLAN;
    }

    public int numberCustomersInStore() {
        return this.countInCustomer.get() - this.countOutCustomer.get();
    }

}

package by.it.brutski.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int PLAN;
    private final AtomicInteger countInCustomer = new AtomicInteger(0);
    private final AtomicInteger countOutCustomer = new AtomicInteger(0);

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public void InCustomer(){
        countInCustomer.getAndIncrement();
    }

    public void OutCustomer(){
        countOutCustomer.getAndIncrement();
    }

    public boolean isOpenedStore(){
        return countInCustomer.get() != PLAN;
    }

    public boolean isClosedStore(){
        return countOutCustomer.get() == PLAN;
    }
}

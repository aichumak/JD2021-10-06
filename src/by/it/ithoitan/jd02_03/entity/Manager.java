package by.it.ithoitan.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int PLAN;
    private final AtomicInteger countIn = new AtomicInteger(0) ;
    private final AtomicInteger countOut = new AtomicInteger(0);

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public void inCustomer() {
        countIn.getAndIncrement();
    }

    public void outCustomer() {
        countOut.getAndIncrement();
    }

    public boolean isOpenStore() {
        return countIn.get() != PLAN;
    }

    public boolean isCloseStore() {
        return countOut.get() == PLAN;
    }


}

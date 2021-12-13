package by.it.chumak.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int PLAN;
    private final int MAX_COUNT_CASHIERS;
    private final AtomicInteger countInCustomer = new AtomicInteger(0);
    private final AtomicInteger countOutCustomer = new AtomicInteger(0);

    public Manager(int plan, int maxCountCashiers) {
        this.PLAN = plan;
        this.MAX_COUNT_CASHIERS = maxCountCashiers;
    }

    public int getCashiersMaxCount() {
        return this.MAX_COUNT_CASHIERS;
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

    public int numberCustomersInStore() {
        return this.countInCustomer.get() - this.countOutCustomer.get();
    }

}

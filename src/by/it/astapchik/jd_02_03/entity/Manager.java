package by.it.astapchik.jd_02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int Plan;
    private final AtomicInteger counterEnteredCustomer = new AtomicInteger(0);
    private final AtomicInteger counterLeftCustomer = new AtomicInteger(0);

    public Manager(int plan) {
        this.Plan = plan;
    }

    public void addCustomer() {
        counterEnteredCustomer.getAndIncrement();
    }

    public void removeCustomer() {
        counterLeftCustomer.getAndIncrement();
    }

    public boolean isOpenedStore() {
        return counterEnteredCustomer.get() != Plan;
    }

    public boolean isClosedStore() {
        return counterLeftCustomer.get() == Plan;
    }

}

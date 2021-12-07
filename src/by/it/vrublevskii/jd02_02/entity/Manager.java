package by.it.vrublevskii.jd02_02.entity;

public class Manager {

    private final int PLAN;
    private volatile int countInCustomer = 0;
    private volatile int countOutCustomer = 0;

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public synchronized void addCustomer() {
        countInCustomer++;
    }

    public synchronized void finishCustomer() {
        countOutCustomer++;
    }

    public boolean isStoreOpen() {
        return countInCustomer != PLAN;
    }

    public boolean isStoreClosed() {
        return countOutCustomer == PLAN;
    }
}

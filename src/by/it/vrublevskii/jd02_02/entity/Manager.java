package by.it.vrublevskii.jd02_02.entity;

public class Manager {

    private final int plan;
    private volatile int countCustomerIn = 0;
    private volatile int countCustomerOut = 0;

    public Manager(int plan) {
        this.plan = plan;
    }

    public int getPlan() {
        return plan;
    }

    public synchronized void addCustomer() {
        countCustomerIn++;
    }

    public synchronized void terminateCustomer() {
        countCustomerOut++;
    }

    public boolean isStoreOpen() {
        return countCustomerIn != plan;
    }

    public boolean isStoreClosed() {
        return countCustomerOut == plan;
    }

}

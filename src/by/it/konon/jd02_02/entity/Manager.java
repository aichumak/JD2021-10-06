package by.it.konon.jd02_02.entity;

public class Manager {

    private final int PLAN;
    private volatile int countInCustomer = 0;
    private volatile int countOutCustomer = 0;

    public Manager(int plan) {
        this.PLAN = plan;

    }



    public synchronized void addCustomer() {
        this.countInCustomer++;
    }

    public synchronized void finishedCustomer() {
        this.countOutCustomer++;
    }

    public boolean isOpenedStore() {
        return this.countInCustomer != this.PLAN;
    }

    public boolean isClosedStore() {
        return this.countOutCustomer == this.PLAN;
    }

    public int numberCustomersInStore() {
        return this.countInCustomer - this.countOutCustomer;
    }

}

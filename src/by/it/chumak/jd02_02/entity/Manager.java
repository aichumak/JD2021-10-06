package by.it.chumak.jd02_02.entity;

public class Manager {

    private final int PLAN;
    private final int MAX_COUNT_CASHIERS;
    private volatile int countInCustomer = 0;
    private volatile int countOutCustomer = 0;

    public Manager(int plan, int maxCountCashiers) {
        this.PLAN = plan;
        this.MAX_COUNT_CASHIERS = maxCountCashiers;
    }

    public int getCashiersMaxCount() {
        return this.MAX_COUNT_CASHIERS;
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

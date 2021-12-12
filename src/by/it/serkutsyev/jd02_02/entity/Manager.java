package by.it.serkutsyev.jd02_02.entity;

public class Manager {
    private final int PLAN;
    private volatile int counterOutCustomer=0;
    private volatile int counterInCustomer=0;

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public synchronized void addCustomer() {
        counterInCustomer++;

    }

    public synchronized void finishedCustomer() {
        counterOutCustomer++;

    }

    public boolean isOpenedStore(){
        return counterInCustomer!=PLAN;
    }

    public boolean isClosedStore(){
        return counterOutCustomer==PLAN;
    }
}

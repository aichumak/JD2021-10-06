package by.it.brutski.jd02_02.entity;

public class Manager {
    private final int PLAN;
    private volatile int countInCustomer = 0;
    private volatile int countOutCustomer = 0;

    public Manager(int plan) {
        this.PLAN = plan;
    }

    public synchronized void InCustomer(){
        countInCustomer++;
    }

    public synchronized void OutCustomer(){
        countOutCustomer++;
    }

    public boolean isOpenedStore(){
        return countInCustomer != PLAN;
    }

    public boolean isClosedStore(){
        return countOutCustomer == PLAN;
    }
}

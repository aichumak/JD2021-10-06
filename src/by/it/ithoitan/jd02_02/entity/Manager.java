package by.it.ithoitan.jd02_02.entity;

public class Manager {
    private final int PLAN;
    private volatile int countIn = 0;
    private volatile int countOut = 0;

    public Manager(int plan) {
        this.PLAN = plan;
    }
    public synchronized void inCustomer(){
        countIn++;
    }
    public synchronized void outCustomer(){
        countOut++;
    }
    public boolean isOpenStore(){
        return countIn!=PLAN;
    }
    public boolean isCloseStore(){
        return countOut==PLAN;
    }




}

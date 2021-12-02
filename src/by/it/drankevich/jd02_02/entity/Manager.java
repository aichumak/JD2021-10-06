package by.it.drankevich.jd02_02.entity;

public class Manager {

    private final int PLAN;
    public volatile int countInCustomer=0;
    private volatile int countOutCustomer=0;

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

    public synchronized void addCustomer(){
        countInCustomer++;
    }
   public synchronized void finishedCustomer(){
        countOutCustomer++;
    }

   public boolean isOpenedStore(){
        return countInCustomer!=PLAN;
    }
    public boolean isClosedStore(){
        return countOutCustomer==PLAN;
    }

}


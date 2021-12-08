package by.it.drankevich.callcenter.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkingDayPlan {

    private final int numberClients;
    AtomicInteger atomicInteger = new AtomicInteger(0);
    AtomicInteger atomicIntegerClosed = new AtomicInteger(0);


    public WorkingDayPlan(int numberClients) {
        this.numberClients = numberClients;
    }

    public void addClientCall() {
        atomicInteger.getAndIncrement();
    }
    public void finishedCall(){
        atomicIntegerClosed.getAndIncrement();
    }

    public boolean isOpened() {
        return (numberClients != atomicInteger.get());
    }

    public boolean isClosed() {
        return (numberClients == atomicIntegerClosed.get());
    }




}

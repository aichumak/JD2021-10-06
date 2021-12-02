package by.it.chumak.jd02_02.service;

import by.it.chumak.jd02_02.entity.Cashier;
import by.it.chumak.jd02_02.entity.Store;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier + "opened");
        while (){

        }
        System.out.println(cashier + "closed");
    }
}

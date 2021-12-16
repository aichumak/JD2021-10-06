package by.it.brutski.jd02_02.service;

import by.it.brutski.jd02_02.entity.Cashier;
import by.it.brutski.jd02_02.entity.Customer;
import by.it.brutski.jd02_02.entity.Store;
import by.it.brutski.jd02_02.helper.RandomGenerator;
import by.it.brutski.jd02_02.helper.TimeOut;

public class CashierWorker implements Runnable{
    private final Store store;
    private final Cashier cashier;

    public CashierWorker(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!store.getManager().isClosedStore()){
            Customer customer = store.getQueue().extract();

            if(customer != null){
                synchronized (customer.getMonitor()){
                    System.out.println(cashier + " start to service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    TimeOut.sleep(timeout);
                    System.out.println(cashier + " finish to service " + customer);
                    customer.setFlag(false);
                    customer.getMonitor().notify();
                }
            } else {
                TimeOut.sleep(100); //Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed");
    }
}

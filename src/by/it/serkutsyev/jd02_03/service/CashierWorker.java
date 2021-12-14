package by.it.serkutsyev.jd02_03.service;

import by.it.serkutsyev.jd02_03.entity.Cashier;
import by.it.serkutsyev.jd02_03.entity.Customer;
import by.it.serkutsyev.jd02_03.entity.Store;
import by.it.serkutsyev.jd02_03.helper.RandomGenerator;
import by.it.serkutsyev.jd02_03.helper.Timeout;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Store store, Cashier cashier) {
        this.cashier = cashier;
        this.store = store;
    }


    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!store.getManager().isClosedStore()) {
            Customer customer = store.getQueue().extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.println(cashier + " started to service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timeout.sleep(timeout);
                    System.out.println(cashier + " finished to service " + customer);
                    customer.setFlagWaiting(false);
                    customer.getMonitor().notify();
                }
            }
            else {
                Object monitor = CashierWorker.class;
                synchronized (monitor){
                    try {monitor.wait(100);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(cashier + " closed");
    }
}

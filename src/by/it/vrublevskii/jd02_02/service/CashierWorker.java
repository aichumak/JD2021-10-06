package by.it.vrublevskii.jd02_02.service;

import by.it.vrublevskii.jd02_02.entity.Cashier;
import by.it.vrublevskii.jd02_02.entity.Customer;
import by.it.vrublevskii.jd02_02.entity.Store;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!store.getManager().isStoreClosed()) {
            Customer customer = store.getQueue().extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.println(cashier + " started to service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timeout.sleep(timeout);
                    System.out.println(cashier + " finished to service " + customer);
                    customer.setFlagWait(false);
                    customer.getMonitor().notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed");
    }
}

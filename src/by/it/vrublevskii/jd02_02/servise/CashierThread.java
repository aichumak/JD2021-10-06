package by.it.vrublevskii.jd02_02.servise;


import by.it.vrublevskii.jd02_02.entity.Cashier;
import by.it.vrublevskii.jd02_02.entity.Customer;
import by.it.vrublevskii.jd02_02.entity.Store;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

public class CashierThread implements Runnable {

    private final Store store;
    private final Cashier cashier;

    public CashierThread(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        System.out.println("\t" + cashier + " started");
        while (!store.getManager().isStoreClosed()) {
            Customer customer = store.getQueue().extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.println("\t" + cashier + " started to service: " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timeout.sleep(timeout);
                    System.out.println("\t" + cashier + " finished to service: " + customer);
                    customer.setFlagWait(false);
                    customer.getMonitor().notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println("\t" + cashier + " finished");
    }
}

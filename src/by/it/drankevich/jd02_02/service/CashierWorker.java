package by.it.drankevich.jd02_02.service;

import by.it.drankevich.jd02_02.entity.Cashier;
import by.it.drankevich.jd02_02.entity.Customer;
import by.it.drankevich.jd02_02.entity.Store;
import by.it.drankevich.jd02_02.helper.RandomGenerator;
import by.it.drankevich.jd02_02.helper.Timeout;

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
        while (!store.getManager().isClosedStore()) {
            Customer customer = store.getQueue().extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.println(cashier + "started servise " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timeout.sleep(timeout);
                    cashier.setTotal(customer.getTotal());
                    System.out.println(cashier + "finished servise " + customer+" TOTAL PRISE=" + customer.getTotal());

                    customer.setFlagWaiting(false);
                    customer.getMonitor().notify();
                }
            } else {
                Timeout.sleep(100);

            }
        }
        System.out.println(cashier + "closed");

    }
}

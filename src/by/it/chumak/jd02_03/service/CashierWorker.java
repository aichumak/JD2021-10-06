package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Cashier;
import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.Store;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

import java.util.Map;

public class CashierWorker implements Runnable {

    private final Cashier CASHIER;
    private final Store STORE;

    public CashierWorker(Store store, Cashier cashier) {
        this.CASHIER = cashier;
        this.STORE = store;
    }

    @Override
    public void run() {
        StoreReportPrinter storeReportPrinter = new StoreReportPrinter();
        while (!STORE.getManager().isClosedStore()) {
            int queueSize = STORE.getQueue().getSize();
            if (queueSize > (5 * (CASHIER.getNumber() - 1))) {

                if (CASHIER.isClosed()) {
                    CASHIER.openCashier();
                    System.out.println(CASHIER + " opened");
                }

                Customer customer = STORE.getQueue().extract();
                if (customer != null) {
                    synchronized (customer.getMonitor()) {
                        System.out.println(CASHIER + " started to service " + customer);
                        int timeout = RandomGenerator.get(2000, 5000);
                        Timeout.sleep(timeout);
                        CASHIER.setTotal(customer.getTotal());
                        storeReportPrinter.printCashierReceipt(STORE, CASHIER.getNumber(), customer);
                        customer.setFlagWaiting(false);
                        customer.getMonitor().notify();
                        System.out.println(CASHIER + " finished to service " + customer);
                    }
                } else {
                    Object monitor = CashierWorker.class;
                    //noinspection SynchronizationOnLocalVariableOrMethodParameter
                    synchronized (monitor) {
                        try {
                            monitor.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                if (!CASHIER.isClosed()) {
                    CASHIER.closeCashier();
                    System.out.println(CASHIER + " is temporary closed");
                }
            }
        }
        System.out.println(CASHIER + " closed");
    }


}
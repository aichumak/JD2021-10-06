package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Cashier;
import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Store;
import by.it.chumak.jd02_03.helper.RandomGenerator;
import by.it.chumak.jd02_03.helper.Timeout;

import java.util.ArrayList;
import java.util.List;

public class CashierWorker implements Runnable {

    private final Cashier CASHIER;
    private final Store STORE;

    public CashierWorker(Store store, Cashier cashier) {
        this.CASHIER = cashier;
        this.STORE = store;
    }

    @Override
    public void run() {
        List<String> cashierStatusList = new ArrayList<>();
        StoreReportPrinter storeReportPrinter = new StoreReportPrinter();
        while (!STORE.getManager().isClosedStore()) {
            int queueSize = STORE.getQueue().getSize();
            if (queueSize > (5 * (CASHIER.getNumber() - 1))) {
                if (CASHIER.isClosed()) {
                    CASHIER.openCashier();
                    cashierStatusList.clear();
                    cashierStatusList.add(CASHIER.getName());
                    cashierStatusList.add("is open");
                    cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
                    storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
                }

                Customer customer = STORE.getQueue().extract();
                if (customer != null) {
                    synchronized (customer.getMonitor()) {
                        cashierStatusList.clear();
                        cashierStatusList.add(CASHIER.getName());
                        cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
                        cashierStatusList.add("started to service:");
                        cashierStatusList.add(customer.getName());
                        storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);

                        int timeout = RandomGenerator.get(2000, 5000);
                        Timeout.sleep(timeout);

                        CASHIER.setTotal(customer.getTotal());
                        STORE.addToTotalProfit(customer.getTotal());
                        storeReportPrinter.printCashierReceipt(STORE, CASHIER.getNumber(), customer);
                        customer.setFlagWaiting(false);
                        customer.getMonitor().notify();

                        cashierStatusList.clear();
                        cashierStatusList.add(CASHIER.getName());
                        cashierStatusList.add("finished to service:");
                        cashierStatusList.add(customer.getName());
                        cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
                        storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
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
                    cashierStatusList.clear();
                    cashierStatusList.add(CASHIER.getName());
                    cashierStatusList.add("is temporary closed");
                    cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
                    storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
                }
            }
        }
        cashierStatusList.clear();
        cashierStatusList.add(CASHIER.getName());
        cashierStatusList.add("is closed");
        cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
        storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
    }

}
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
                    getCashierStatusList(cashierStatusList, "is open");
                    storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
                }

                Customer customer = STORE.getQueue().extract();
                if (customer != null) {
                    synchronized (customer.getMonitor()) {
                        getCashierStatusList(cashierStatusList, customer, "started to service:");
                        storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);

                        int timeout = RandomGenerator.get(2000, 5000);
                        Timeout.sleep(timeout);

                        CASHIER.setTotal(customer.getTotal());
                        STORE.addToTotalProfit(customer.getTotal());
                        storeReportPrinter.printCashierReceipt(STORE, CASHIER.getNumber(), customer);
                        customer.setFlagWaiting(false);
                        customer.getMonitor().notify();

                        getCashierStatusList(cashierStatusList, customer, "finished to service:");
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
                    getCashierStatusList(cashierStatusList, "is temporary closed");
                    storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
                }
            }
        }
        getCashierStatusList(cashierStatusList, "is closed");
        storeReportPrinter.printCashierStatus(STORE, CASHIER.getNumber(), cashierStatusList);
    }

    private void getCashierStatusList(List<String> cashierStatusList, Customer customer, String statusText) {
        cashierStatusList.clear();
        cashierStatusList.add("--------------------");
        cashierStatusList.add(CASHIER.getName());
        cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
        cashierStatusList.add(statusText);
        cashierStatusList.add(customer.getName());
        cashierStatusList.add("====================");
    }

    private void getCashierStatusList(List<String> cashierStatusList, String statusText) {
        cashierStatusList.clear();
        cashierStatusList.add("--------------------");
        cashierStatusList.add(CASHIER.getName());
        cashierStatusList.add("Total:" + CASHIER.getTotal() + "$");
        cashierStatusList.add(statusText);
        cashierStatusList.add("====================");
    }

}
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
                    printReceipt(customer);
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

    private void printReceipt(Customer customer) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(customer.getName());
        System.out.println();
        stringBuffer.append(" RECEIPT\n");
        stringBuffer.append("-------------------------------\n");
        stringBuffer.append("-------------------------------\n");

        for (Map.Entry<Good, Integer> entry : customer.getShoppingCard().getCart().entrySet()) {
            double goodsPrice = STORE.getStorePriceList().getGoodsPrice(entry.getKey().getName());
            double goodsCount = customer.getShoppingCard().getGoodCount(entry.getKey());

            stringBuffer.append("*** Good: ");
            stringBuffer.append(entry.getKey().getName());
            stringBuffer.append(", goods price: ");
            stringBuffer.append(goodsPrice);
            stringBuffer.append("$   ");
            stringBuffer.append(goodsCount);
            stringBuffer.append(" * ");
            stringBuffer.append(goodsPrice);
            stringBuffer.append("$ = ");
            stringBuffer.append(goodsCount * goodsPrice);
            stringBuffer.append("$\n");
        }

        stringBuffer.append("-------------------------------\n");
        stringBuffer.append("RECEIPT TOTAL: ");
        stringBuffer.append(customer.getTotal());
        stringBuffer.append("$\n");
        System.out.println(stringBuffer);
    }

}
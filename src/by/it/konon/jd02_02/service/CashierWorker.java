package by.it.konon.jd02_02.service;

import by.it.konon.jd02_02.entity.Cashier;
import by.it.konon.jd02_02.entity.Customer;
import by.it.konon.jd02_02.entity.Good;
import by.it.konon.jd02_02.entity.Store;
import by.it.konon.jd02_02.helper.RandomGenerator;
import by.it.konon.jd02_02.helper.Timeout;

import java.util.Map;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Store store, Cashier cashier) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        while (!store.getManager().isClosedStore()) {
                Customer customer = store.getQueue().extract();
                if (customer != null) {
                    synchronized (customer.getMonitor()) {
                        System.out.println(cashier + " started to service " + customer);
                        int timeout = RandomGenerator.get(2000, 5000);
                        Timeout.sleep(timeout);
                        shoppingBill(customer);
                        customer.setFlagWaiting(false);
                        customer.getMonitor().notify();
                        System.out.println(cashier + " finished to service " + customer);
                    }
                } else {
                    Timeout.sleep(100);
                }

                Timeout.sleep(100);
            }
    }



    private void shoppingBill(Customer customer) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(customer.getName());
        System.out.println();
        stringBuffer.append(" SHOPPING BILL\n");
        stringBuffer.append("////////////////////////////////////////////////////////////\n");


        for (Map.Entry<Good, Integer> entry : customer.getShoppingCard().getCart().entrySet()) {
            double goodsPrice = store.getStorePriceList().getGoodsPrice(entry.getKey().getName());
            double goodsCount = customer.getShoppingCard().getGoodCount(entry.getKey());

            stringBuffer.append("Good: ");
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
        stringBuffer.append("SHOPPING BILL TOTAL: ");
        stringBuffer.append(customer.getTotal());
        stringBuffer.append("$\n");
        System.out.println(stringBuffer);
    }

}
package by.it.vrublevskii.jd02_02.servise;


import by.it.vrublevskii.jd02_02.entity.*;
import by.it.vrublevskii.jd02_02.helper.RandomGenerator;
import by.it.vrublevskii.jd02_02.helper.Timeout;

import java.util.ArrayList;
import java.util.Iterator;

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
                    double total = this.countTotal(customer);
                    String check = this.makeCheck(customer);
                    printCheck(check);
                    System.out.println("\t"
                            + cashier
                            + " finished to service: "
                            + customer
                            + ".\n\tTotal price: "
                            + customer.getShoppingCart().getPriceTotal());
                    System.out.println();
                    customer.setFlagWait(false);
                    customer.getMonitor().notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println("\t" + cashier + " finished");
    }

    public String makeCheck(Customer customer) {
        Iterator<Good> goodsInCartIterator = getGoodsInCartIterator(customer);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        while (goodsInCartIterator.hasNext()) {
            stringBuilder.append("\t");
            stringBuilder.append(goodsInCartIterator.next());
            if (goodsInCartIterator.hasNext()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void printCheck(String check) {
        System.out.println(check);
    }

    public double countTotal(Customer customer) {
        Iterator<Good> goodsInCartIterator = getGoodsInCartIterator(customer);
        while (goodsInCartIterator.hasNext()) {
            cashier.setTotal(cashier.getTotal() + goodsInCartIterator.next().getPrice());
        }
        return cashier.getTotal();
    }

    private Iterator<Good> getGoodsInCartIterator(Customer customer) {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        ArrayList<Good> goodsInCart = shoppingCart.getGoodsInCart();
        Iterator<Good> iterator = goodsInCart.iterator();
        return iterator;
    }
}

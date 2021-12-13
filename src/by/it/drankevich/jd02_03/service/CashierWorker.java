package by.it.drankevich.jd02_03.service;

import by.it.drankevich.jd02_03.entity.Cashier;
import by.it.drankevich.jd02_03.entity.Customer;
import by.it.drankevich.jd02_03.entity.Good;
import by.it.drankevich.jd02_03.entity.Store;
import by.it.drankevich.jd02_03.helper.RandomGenerator;
import by.it.drankevich.jd02_03.helper.Timeout;

import java.util.concurrent.Semaphore;

@SuppressWarnings({"RedundantStringFormatCall", "ConstantConditions", "MalformedFormatString"})
public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;
    public static int countQueue = 0;
    public int sizeQueue = 0;
    private static final Semaphore semaphore = new Semaphore(1);

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        while (!store.getManager().isClosedStore()) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sizeQueue = store.getQueue().getCustomerDeque().size() - countQueue;
            if (sizeQueue > 0) {
                if (countQueue == 0) {
                    countQueue = countQueue + 4;
                } else countQueue = countQueue + 5;


            }
            semaphore.release();


            if (sizeQueue > 0) {

                System.out.println(cashier + "opened");

                while (store.getQueue().getCustomerDeque().size() != 0) {
                    Customer customer = store.getQueue().extract();
                    if (customer != null) {
                        synchronized (customer.getMonitor()) {
                            System.out.println(cashier + "started servise " + customer);
                            int timeout = RandomGenerator.get(2000, 5000);
                            Timeout.sleep(timeout);
                            cashier.setTotal(customer.getTotal());
                            printChek(cashier.getName(),customer);

                            customer.setFlagWaiting(false);
                            customer.getMonitor().notify();
                        }
                    } else {
                        System.out.println(cashier + "closed");
                        try {
                            semaphore.acquire();
                            countQueue = countQueue - 5;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        semaphore.release();


                    }
                }
            }
        }
        System.out.println(cashier + "closed");


    }

    private void printChek(String name, Customer customer) {
        switch (name) {
            case "Cashier №1":

                String as = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                String as1 = String.format("|%-27s|%29s|%29s|%29s|%29s|%10d people|%10s|", cashier, "", "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                String as2 = String.format("%27s%29s%29s%29s%29s%10s%10s", customer, "", "", "", "", "", "");
                Good good = customer.shoppingCart.cart.remove(0);
                String as3 = String.format("%27s%29s%29s%29s%29s%10s%10s", good, "", "", "", "", "", "");
                String as31;
                if (customer.shoppingCart.cart.size() == 0) as31 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    as31 = String.format("%27s%29s%29s%29s%29s%10s%10s", good, "", "", "", "", "", "");
                }
                String as32;
                if (customer.shoppingCart.cart.size() == 0) as32 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    as32 = String.format("%27s%29s%29s%29s%29s%10s%10s", good, "", "", "", "", "", "");
                }
                String as33;
                if (customer.shoppingCart.cart.size() == 0) as33 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    as33 = String.format("%27s%29s%29s%29s%29s%10s%10s", good, "", "", "", "", "", "");
                }
                String as34;
                if (customer.shoppingCart.cart.size() == 0) as34 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    as34 = String.format("%27s%29s%29s%29s%29s%10s%10s", good, "", "", "", "", "", "");
                }
                String as4 = String.format("TOTAL %-27.2f%29s%29s%29s%29s%10s%10s", customer.getTotal(), "", "", "", "", "", "");
                String as5 = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", as, as1, as2, as3, as31, as32, as33, as34, as4, as5);
                break;

            case "Cashier №2":
                String bs = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                String bs1 = String.format("|%29s|%-29s|%29s|%29s|%29s|%10d people|%10s|", "", cashier, "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                String bs2 = String.format("%31s%-29s%29s%29s%29s%10s%10s", "", customer, "", "", "", "", "");


                good = customer.shoppingCart.cart.remove(0);
                String bs3 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", good, "", "", "", "", "");

                String bs31;
                if (customer.shoppingCart.cart.size() == 0) bs31 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    bs31 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", good, "", "", "", "", "");
                }

                String bs32;
                if (customer.shoppingCart.cart.size() == 0) bs32 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    bs32 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", good, "", "", "", "", "");
                }

                String bs33;
                if (customer.shoppingCart.cart.size() == 0) bs33 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    bs33 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", good, "", "", "", "", "");
                }

                String bs34;
                if (customer.shoppingCart.cart.size() == 0) bs34 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    bs34 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", good, "", "", "", "", "");
                }
                String bs4 = String.format("%29sTOTAL %-29.2f%29s%29s%29s%10s%10s", "", customer.getTotal(), "", "", "", "", "");
                String bs5 = String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", bs, bs1, bs2, bs3, bs31, bs32, bs33, bs34, bs4, bs5);

                break;
            case "Cashier №3":
                String cs = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                String cs1 = String.format("|%29s|%29s|%-27s|%29s|%29s|%10d people|%10s|", "", "", cashier, "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                String cs2 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", customer, "", "", "", "");
                good = customer.shoppingCart.cart.remove(0);
                String cs3 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", good, "", "", "", "", "");
                String cs31;
                if (customer.shoppingCart.cart.size() == 0) cs31 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    cs31 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", good, "", "", "", "", "");
                }
                String cs32;
                if (customer.shoppingCart.cart.size() == 0) cs32 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    cs32 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", good, "", "", "", "", "");
                }
                String cs33;
                if (customer.shoppingCart.cart.size() == 0) cs33 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    cs33 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", good, "", "", "", "", "");
                }
                String cs34;
                if (customer.shoppingCart.cart.size() == 0) cs34 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    cs34 = String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", good, "", "", "", "", "");
                }

                String cs4 = String.format("%29s%32sTOTAL %-29.2f%29s%29s%10s%10s", "", "", customer.getTotal(), "", "", "", "", "");
                String cs5 = String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", cs, cs1, cs2, cs3, cs31, cs32, cs33, cs34, cs4, cs5);

                break;
            case "Cashier №4":
                String ds = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                String ds1 = String.format("|%29s|%29s|%29s|%-29s|%29s|%10d people|%10s|", "", "", "", cashier, "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                String ds2 = String.format("%29s%29s%29s%29s%29s%10s%10s", "", "", "", customer, "", "", "");
                good = customer.shoppingCart.cart.remove(0);
                String ds3 = String.format("%29s%29s%29s%29s%29s%10s", "", "", "", good, "", "", "");
                String ds31;
                if (customer.shoppingCart.cart.size() == 0) ds31 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    ds31 = String.format("%29s%29s%29s%29s%29s%10s", "", "", "", good, "", "", "");
                }
                String ds32;
                if (customer.shoppingCart.cart.size() == 0) ds32 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    ds32 = String.format("%29s%29s%29s%29s%29s%10s", "", "", "", good, "", "", "");
                }
                String ds33;
                if (customer.shoppingCart.cart.size() == 0) ds33 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    ds33 = String.format("%29s%29s%29s%29s%29s%10s", "", "", "", good, "", "", "");
                }
                String ds34;
                if (customer.shoppingCart.cart.size() == 0) ds34 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    ds34 = String.format("%29s%29s%29s%29s%29s%10s", "", "", "", good, "", "", "");
                }
                String ds4 = String.format("%33s%29s%29sTOTAL %-29.2f%29s%10s%10s", "", "", "", customer.getTotal(), "", "", "");
                String ds5 = String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", ds, ds1, ds2, ds3, ds31, ds32, ds33, ds34, ds4, ds5);

                break;
            case "Cashier №5":
                String es = String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                String es1 = String.format("|%29s|%29s|%29s|%29s|%-27s|%10d people|%10s|", "", "", "", "", cashier, store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                String es2 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", customer, "", "");
                good = customer.shoppingCart.cart.remove(0);
                String es3 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", good, "", "");
                String es31;
                if (customer.shoppingCart.cart.size() == 0) es31 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    es31 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", good, "", "");
                }
                String es32;
                if (customer.shoppingCart.cart.size() == 0) es32 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    es32 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", good, "", "");
                }
                String es33;
                if (customer.shoppingCart.cart.size() == 0) es33 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    es33 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", good, "", "");
                }
                String es34;
                if (customer.shoppingCart.cart.size() == 0) es34 = "";
                else {
                    good = customer.shoppingCart.cart.remove(0);
                    es34 = String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", good, "", "");
                }
                String es4 = String.format("%31s%29s%29s%29sTOTAL %-27.2f%10s%10s", "", "", "", "", customer.getTotal(), "", "");
                String es5 = String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", es, es1, es2, es3, es31, es32, es33, es34, es4, es5);
                break;

        }
    }
}

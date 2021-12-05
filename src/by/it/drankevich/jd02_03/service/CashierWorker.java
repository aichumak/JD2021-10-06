package by.it.drankevich.jd02_03.service;

import by.it.drankevich.jd02_03.entity.Cashier;
import by.it.drankevich.jd02_03.entity.Customer;
import by.it.drankevich.jd02_03.entity.Store;
import by.it.drankevich.jd02_03.helper.RandomGenerator;
import by.it.drankevich.jd02_03.helper.Timeout;

import java.util.concurrent.Semaphore;

@SuppressWarnings("RedundantStringFormatCall")
public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;
    public static int countQueue = 0;
    public int sizeQueue = 0;
    private static final Semaphore semaphorePrint = new Semaphore(1);
    private static final Semaphore semaphore = new Semaphore(1);
    int count = 0;

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
            count++;
            if (count == 50) {
                Timeout.sleep(1000);
                count=0;
            }

            if (sizeQueue > 0) {

                System.out.println(cashier + "opened");

                do {
                    Customer customer = store.getQueue().extract();
                    if (customer != null) {
                        synchronized (customer.getMonitor()) {
                            System.out.println(cashier + "started servise " + customer);
                            int timeout = RandomGenerator.get(2000, 5000);
                            Timeout.sleep(timeout);
                            cashier.setTotal(customer.getTotal());
                            try {
                                semaphorePrint.acquire();


                                switch (cashier.getName()) {
                                    case "Cashier №1":
                                        String as= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String as1= String.format("|%-27s|%29s|%29s|%29s|%29s|%10d people|%10s|", cashier,"", "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String as2= String.format("%27s%29s%29s%29s%29s%10s%10s",customer,"", "", "", "","","");
                                        String as3= String.format("%27s%29s%29s%29s%29s%10s%10s",customer.shoppingCart.print(),"", "", "", "","","");
                                        String as4= String.format("TOTAL %-27.2f%29s%29s%29s%29s%10s%10s",customer.getTotal(),"", "", "", "","","");
                                        String as5= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",as,as1,as2,as3,as4,as5);
                                        semaphorePrint.release();
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №2":
                                        String bs= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String bs1= String.format("|%29s|%-29s|%29s|%29s|%29s|%10d people|%10s|", "", cashier, "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String bs2= String.format("%29s%29s%29s%29s%29s%10s%10s", "", customer, "", "", "", "", "");
                                        String bs3= String.format("%29s%29s%29s%29s%29s%10s%10s", "", customer.shoppingCart.print(), "", "", "", "", "");
                                        String bs4= String.format("%29sTOTAL %-29.2f%29s%29s%29s%10s%10s", "", customer.getTotal(), "", "", "", "", "");
                                        String bs5= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",bs,bs1,bs2,bs3,bs4,bs5);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №3":
                                        String cs= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String cs1= String.format("|%29s|%29s|%-27s|%29s|%29s|%10d people|%10s|", "", "", cashier, "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String cs2= String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", customer, "", "", "","");
                                        String cs3= String.format("%29s%29s%27s%29s%29s%10s%10s", "", "", customer.shoppingCart.print(), "", "", "", "","");
                                        String cs4= String.format("%29s%29sTOTAL %-27.2f%29s%29s%10s%10s", "", "", customer.getTotal(), "", "", "", "","");
                                        String cs5= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",cs,cs1,cs2,cs3,cs4,cs5);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №4":
                                        String ds= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String ds1= String.format("|%29s|%29s|%29s|%-29s|%29s|%10d people|%10s|", "", "", "", cashier, "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String ds2= String.format("%29s%29s%29s%29s%29s%10s%10s", "", "", "", customer, "", "", "");
                                        String ds3= String.format("%29s%29s%29s%29s%29s%10s", "", "", "", customer.shoppingCart.print(), "", "", "");
                                        String ds4= String.format("%29s%29s%29sTOTAL %-29.2f%29s%10s%10s", "", "", "", customer.getTotal(), "", "", "");
                                        String ds5= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",ds,ds1,ds2,ds3,ds4,ds5);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №5":
                                        String es= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String es1= String.format("|%29s|%29s|%29s|%29s|%-27s|%10d people|%10s|", "", "", "", "", cashier, store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String es2= String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", customer, "", "");
                                        String es3= String.format("%29s%29s%29s%29s%27s%10s%10s", "", "", "", "", customer.shoppingCart.print(), "", "");
                                        String es4= String.format("%29s%29s%29s%29sTOTAL %-27.2f%10s%10s", "", "", "", "", customer.getTotal(), "", "");
                                        String es5= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",es,es1,es2,es3,es4,es5);
                                        semaphorePrint.release();
                                        break;

                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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
                } while (store.getQueue().getCustomerDeque().size() > 0);
            }
        }
          System.out.println(cashier + "closed");



    }
}

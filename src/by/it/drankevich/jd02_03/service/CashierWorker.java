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
                                        String s= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String s1= String.format("|%-27s|%29s|%29s|%29s|%29s|%10d people|%10s|", cashier," ", "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String s2= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n",s,s1,s2);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №2":
                                        String s3= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String s4= String.format("|%29s|%-29s|%29s|%29s|%29s|%10d people|%10s|", "", cashier, "", "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String s5= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n",s3,s4,s5);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №3":
                                        String s6= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String s7= String.format("|%29s|%29s|%-27s|%29s|%29s|%10d people|%10s|", "", "", cashier, "", "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String s8= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n",s6,s7,s8);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №4":
                                        String s9= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String s10= String.format("|%29s|%29s|%29s|%-29s|%29s|%10d people|%10s|", "", "", "", cashier, "", store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String s11= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n",s9,s10,s11);
                                        semaphorePrint.release();
                                        break;
                                    case "Cashier №5":
                                        String s12= String.format("____________________________________________________________________________________________________________________________________________________________________________________");
                                        String s13= String.format("|%29s|%29s|%29s|%29s|%-27s|%10d people|%10s|", "", "", "", "", cashier, store.getQueue().getCustomerDeque().size(), Cashier.getTotalStoreCash());
                                        String s14= String.format("___________________________________________________________________________________________________________________________________________________________________________________");
                                        System.out.printf("%s\n%s\n%s\n",s12,s13,s14);
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

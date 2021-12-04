package by.it.drankevich.jd02_03.service;

import by.it.drankevich.jd02_03.entity.Cashier;
import by.it.drankevich.jd02_03.entity.Customer;
import by.it.drankevich.jd02_03.entity.Store;
import by.it.drankevich.jd02_03.helper.RandomGenerator;
import by.it.drankevich.jd02_03.helper.Timeout;

import java.util.concurrent.Semaphore;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;
    public static volatile Integer countQueue = 0;
    public static final Integer monitorSizeQueue = 0;
    public  int sizeQueue=0;
    private static final Semaphore semaphorePrint=new Semaphore(1);

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        while (!store.getManager().isClosedStore()) {


            synchronized (monitorSizeQueue) {

                sizeQueue = store.getQueue().getCustomerDeque().size() - countQueue;
                if(sizeQueue>0){ countQueue = countQueue + 5;

             }
            }

            if(sizeQueue>0) {
                System.out.println(cashier + "opened");

                do {
                    Customer customer = store.getQueue().extract();
                    if (customer != null) {
                        synchronized (customer.getMonitor()) {
                            System.out.println(cashier + "started servise " + customer);
                            int timeout = RandomGenerator.get(2000, 5000);
                            Timeout.sleep(timeout);
                            cashier.setTotal(customer.getTotal());
                            System.out.println(cashier + "finished servise " + customer + " TOTAL PRISE=" + customer.getTotal());

                            customer.setFlagWaiting(false);
                            customer.getMonitor().notify();
                        }
                    } else {
                        System.out.println(cashier + "closed");
                        synchronized (monitorSizeQueue){
                        countQueue = countQueue - 5;}

                    }
                }while (store.getQueue().getCustomerDeque().size()>0);
            }
        }
     //   System.out.println(cashier + "closed");
        try {
            semaphorePrint.acquire();

        switch (cashier.getName()){
            case "Cashier №1":
                System.out.printf("|%-27s|%29s|%29s|%29s|%29s|%10d people|%10s|\n",cashier,"","","","",store.getQueue().getCustomerDeque().size(),Cashier.getTotalStoreCash());
                System.out.println("____________________________________________________________________________________________________________________________________________________________________________________");
                semaphorePrint.release();
                break;
            case "Cashier №2":
                System.out.printf("|%29s|%-29s|%29s|%29s|%29s|%10d people|%10s|\n","",cashier,"","","",store.getQueue().getCustomerDeque().size(),Cashier.getTotalStoreCash());
                System.out.println("___________________________________________________________________________________________________________________________________________________________________________________");
                semaphorePrint.release();
                break;
            case "Cashier №3":
                System.out.printf("|%29s|%29s|%-27s|%29s|%29s|%10d people|%10s|\n","","",cashier,"","",store.getQueue().getCustomerDeque().size(),Cashier.getTotalStoreCash());
                System.out.println("___________________________________________________________________________________________________________________________________________________________________________________");
                semaphorePrint.release();
                break;
            case "Cashier №4":
                System.out.printf("|%29s|%29s|%29s|%-29s|%29s|%10d people|%10s|\n","","","",cashier,"",store.getQueue().getCustomerDeque().size(),Cashier.getTotalStoreCash());
                System.out.println("___________________________________________________________________________________________________________________________________________________________________________________");
                semaphorePrint.release();
                break;
            case "Cashier №5":
                System.out.printf("|%29s|%29s|%29s|%29s|%-27s|%10d people|%10s|\n","","","","",cashier,store.getQueue().getCustomerDeque().size(),Cashier.getTotalStoreCash());
                System.out.println("___________________________________________________________________________________________________________________________________________________________________________________");
                semaphorePrint.release();
                break;

        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

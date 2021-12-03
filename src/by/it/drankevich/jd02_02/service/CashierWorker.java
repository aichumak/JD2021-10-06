package by.it.drankevich.jd02_02.service;

import by.it.drankevich.jd02_02.entity.Cashier;
import by.it.drankevich.jd02_02.entity.Customer;
import by.it.drankevich.jd02_02.entity.Store;
import by.it.drankevich.jd02_02.helper.RandomGenerator;
import by.it.drankevich.jd02_02.helper.Timeout;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;
    public static volatile Integer countQueue = 0;
    public static final Integer monitorSizeQueue = 0;
    public int sizeQueue=0;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        while (!store.getManager().isClosedStore()) {


            synchronized (monitorSizeQueue) {
                if(countQueue<21){
                sizeQueue = store.getQueue().getCustomerDeque().size() - countQueue;
                if(sizeQueue>0){ countQueue = countQueue + 5;
                }
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
        System.out.println(cashier + "closed");

    }
}

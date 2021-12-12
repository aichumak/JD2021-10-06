package by.it.brutski.jd02_03.service;

import by.it.brutski.jd02_03.entity.Cashier;
import by.it.brutski.jd02_03.entity.Customer;
import by.it.brutski.jd02_03.entity.Store;
import by.it.brutski.jd02_03.helper.RandomGenerator;
import by.it.brutski.jd02_03.helper.TimeOut;

public class CashierWorker implements Runnable{
    private final Store store;
    private final Cashier cashier;

    public CashierWorker(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!store.getManager().isClosedStore()){
            Customer customer = store.getQueue().extract();

            if(customer != null){
                synchronized (customer.getMonitor()){
                    System.out.println(cashier + " start to service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    TimeOut.sleep(timeout);
                    System.out.println(cashier + " finish to service " + customer);
                    customer.setFlag(false);
                    customer.getMonitor().notify();
                }
            } else {
                Object monitor = CashierWorker.class;
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (monitor){
                    try {
                        monitor.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(cashier + " closed");
    }
}

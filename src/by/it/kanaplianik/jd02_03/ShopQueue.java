package by.it.kanaplianik.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;

public class ShopQueue {

    private final LinkedBlockingDeque<TypicalCustomer> customers;

    public ShopQueue(int size) {
        customers = new LinkedBlockingDeque<>(size);
    }

    public void letIn(TypicalCustomer typicalCustomer) {
        try {
            customers.putLast(typicalCustomer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Customer %s is in the QUEUE \n", typicalCustomer.toString());
    }

    public TypicalCustomer letGoOutFromQueue() {
        synchronized (customers) {
            if (customers.size() == 0) {
                return null;
            } else {
                return customers.pollFirst();
            }
        }
    }
}

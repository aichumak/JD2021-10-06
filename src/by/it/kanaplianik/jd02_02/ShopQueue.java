package by.it.kanaplianik.jd02_02;

import java.util.ArrayList;

public class ShopQueue {
    private final ArrayList <TypicalCustomer> customers = new ArrayList<>();

    public void letIn(TypicalCustomer typicalCustomer) {
        synchronized (customers) {
            customers.add(typicalCustomer);

            System.out.printf("Customer %s is in the QUEUE \n", typicalCustomer.toString());
        }
    }
    public TypicalCustomer letGoOutFromQueue() {
        synchronized (customers) {
            if (customers.size()==0) {
                return null;
            }
            else {
                var someCustomer = customers.get(0);
                customers.remove(0);
                return someCustomer;
            }
        }
    }
}

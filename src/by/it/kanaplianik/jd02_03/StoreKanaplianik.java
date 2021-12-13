package by.it.kanaplianik.jd02_03;

public class StoreKanaplianik {

    private final NumberOfCustomers numberOfCustomersInside = new NumberOfCustomers();
    private final ShopQueue shopQueue = new ShopQueue(30);
    private final Cashier firstCashiere = new Cashier(shopQueue, numberOfCustomersInside, 1);
    private final Cashier secondCashiere = new Cashier(shopQueue, numberOfCustomersInside, 2);

    public void letCustomerIn(TypicalCustomer customer) {

        numberOfCustomersInside.increment();

        new Thread(new Runnable() {
            @Override
            public void run() {
                customer.enteredStore();
                customer.chooseGood();
                customer.goToQueue(shopQueue);
            }
        }).start();
    }

    public void waitForCustomersToCheckOutAndCloseStore() {
        firstCashiere.endDuty();
        secondCashiere.endDuty();

        System.out.println("Closing shop");
    }
}

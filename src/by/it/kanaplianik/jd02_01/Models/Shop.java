package by.it.kanaplianik.jd02_01.Models;

public class Shop {
    private int numberOfCustomersInside = 1;

    public void letCustomerIn(Customer customer) {
        System.out.printf(String.format("%s customers inside the shop \n", numberOfCustomersInside));
        numberOfCustomersInside++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                customer.enteredStore();
                customer.chooseGood();
                customer.goOut();
                numberOfCustomersInside--;
            }
        }).start();
    }
}

package by.it.kanaplianik.jd02_02;

import java.util.Random;

public class Cashier {

    public Cashier(ShopQueue shopQueue, NumberOfCustomers numberOfCustomers, int number) {
        this.name = "Cashier №" + number;

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Working day start for cashier " + number);

                while (true) {
                    var customer = shopQueue.letGoOutFromQueue();

                    if (customer!=null) {

                        System.out.println("Processing customer " + customer + " by cashier " + number);

                        Random random = new Random();
                        long waitTimeMs = random.nextLong(2000, 5000);

                        try {
                            Thread.sleep(waitTimeMs);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Processed customer " + customer + " by cashier " + number);

                        customer.goOut();
                        numberOfCustomers.decrement();

                        continue;
                    } else {
                        System.out.println("Cashier " + number + " checked that nobody in the queue");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private String name;
    private double total;
}

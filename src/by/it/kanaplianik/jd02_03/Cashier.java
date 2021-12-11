package by.it.kanaplianik.jd02_03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cashier {

    private final String name;
    private boolean dutyEnded;

    public Cashier(ShopQueue shopQueue, NumberOfCustomers numberOfCustomers, int number) {
        this.name = "Cashier №" + number;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.execute(new Runnable() {
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

                        if (dutyEnded) {
                            threadPool.shutdown();

                            System.out.println(name + " ended his/her work.");

                            return;
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void endDuty() {
        this.dutyEnded = true;

        System.out.println(name + " ending his/her work.");
    }
}

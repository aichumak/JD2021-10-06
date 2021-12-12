package by.it.kanaplianik.jd02_01.Models;

import java.util.Random;

public class Customer {
    private static int numberOfCustomer = 1;
    int customerId;

    public Customer () {
        customerId = numberOfCustomer;
        numberOfCustomer++;
    }

    void enteredStore () {
        System.out.printf(String.format("I am here %s \n", customerId));
    }

    void goOut() {
        System.out.printf(String.format("I am customer %s leaved this shop \n ", customerId));
    }

    public final void chooseGood() {
        Random random = new Random();
        long waitTimeMs = random.nextLong(500, 2000);

        try {
            Thread.sleep(waitTimeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


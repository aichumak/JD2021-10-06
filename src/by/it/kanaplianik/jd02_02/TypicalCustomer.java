package by.it.kanaplianik.jd02_02;

import java.util.Random;

public class TypicalCustomer {
    private static int numberOfCustomer = 1;
    int customerId;

    public TypicalCustomer() {
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

    public void goToQueue(ShopQueue shopQueue) {
        shopQueue.letIn(this);
    }

    @Override
    public String toString () {
        return "TypicalCustomer " + customerId;
    }
}


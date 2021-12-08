package by.it.kanaplianik.jd02_03;

import java.util.Random;

public class WorkingDayModel {

    public static void main(String[] args) {
        System.out.println("Shop open");
        StoreKanaplianik storeKanaplianik = new StoreKanaplianik();
        Random random = new Random();
        int numberOfCustomersEntered = 0;
        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(3);
            for (int j = 0; j < randomNumber; j++) {
                if (numberOfCustomersEntered >= 100) {
                    break;
                }

                storeKanaplianik.letCustomerIn(new TypicalCustomer());
                numberOfCustomersEntered++;
            }

            if (numberOfCustomersEntered >= 100) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        storeKanaplianik.waitForCustomersToCheckOutAndCloseStore();
    }
}


package by.it.kanaplianik.jd02_02;

import java.util.Random;

public class WorkingDayModel {

    public static void main(String[] args) {
        StoreKanaplianik storeKanaplianik = new StoreKanaplianik();
        Random random = new Random();
        for (int i = 0; i <= 100; i++) {
            int randomNumber = random.nextInt(3);
            for (int j = 0; j < randomNumber; j++) {
                storeKanaplianik.letCustomerIn(new TypicalCustomer());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


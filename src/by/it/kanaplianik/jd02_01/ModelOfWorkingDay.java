package by.it.kanaplianik.jd02_01;

import by.it.kanaplianik.jd02_01.Models.Customer;
import by.it.kanaplianik.jd02_01.Models.Shop;

import java.util.Random;

public class ModelOfWorkingDay {

    public static void main(String[] args) {
        Shop shop = new Shop();
        Random random = new Random();
        for (int i = 0; i <= 120; i++) {
            int randomNumber = random.nextInt(3);
            for (int j = 0; j < randomNumber; j++) {
                shop.letCustomerIn(new Customer());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


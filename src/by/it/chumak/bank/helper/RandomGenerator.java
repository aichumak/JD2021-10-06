package by.it.chumak.bank.helper;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();

    public static int get(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }

    public static int get(int max) {
        if (max <= 0) {
            return 0;
        } else {
            return get(0, max);
        }
    }
}

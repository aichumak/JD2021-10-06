package by.it.vrublevskii.jd02_01.helper;

import java.util.Random;

public class RandomGenerator {

    public static final Random random = new Random();

    private RandomGenerator() {
    }

    public static int get(int max) {
        return get(0, max);
    }

    public static int get(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}

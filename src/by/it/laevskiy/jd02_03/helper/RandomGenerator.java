package by.it.laevskiy.jd02_03.helper;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int get(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static int get(int max) {
        return random.nextInt(max + 1);
    }
}

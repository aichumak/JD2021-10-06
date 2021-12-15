package by.it.brutski.jd02_03.helper;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static int get(int min, int max){
        return min + random.nextInt(max - min + 1);
    }

    //от 0 до max:
    public static int get(int max){
        return get(0, max);
    }

}

package by.it.astapchik.jd02_01.helper;

import java.util.Random;

public class GenerateRandomNumbers  {
    private static Random random = new Random();

    public static int get(int min, int max){
        return min + random.nextInt(max - min + 1);
    }

    public static int get(int max){
        return get(0, max);
    }
}

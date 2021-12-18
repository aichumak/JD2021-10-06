package by.it.chumak.jd02_07.helpers;

public class Timeout {

    public static final int K_SPEED = 100;

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        sleep(timeout);
    }
}

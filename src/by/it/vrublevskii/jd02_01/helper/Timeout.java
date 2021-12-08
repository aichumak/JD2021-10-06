package by.it.vrublevskii.jd02_01.helper;

public class Timeout {

    private static final int K_SPEED = 100;

    public static void sleep(int millis){
        try {
            Thread.sleep(millis/K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

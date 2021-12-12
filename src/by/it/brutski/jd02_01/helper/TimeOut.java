package by.it.brutski.jd02_01.helper;

public class TimeOut {
    public static final int K_SPEED = 100;

    public static void sleep(int mil_second){
        try {
            Thread.sleep(mil_second / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

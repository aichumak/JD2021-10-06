package by.it.vrublevskii.jd02_01.helper;

public class Timeout {

    private Timeout() {
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis/100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

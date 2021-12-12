package by.it.astapchik.jd_02_02.helper;

public class Timeout {
    private static final int boost = 100;
    public static void sleep(int milis){
        try {
            Thread.sleep(milis/boost);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

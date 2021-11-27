package by.it.ithoitan.jd02_02.helper;

public class TimeOut {
    public void sleep(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

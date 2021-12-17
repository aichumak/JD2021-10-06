package by.it.vrublevskii.jd02_06;

public class Client {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Log logger = Logger.getLog();
                ((Logger)logger).getErrorMoment();
                logger.error("error1");
                logger.info("info1");
            }).start();

        }
    }
}

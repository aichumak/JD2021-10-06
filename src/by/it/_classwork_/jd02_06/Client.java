package by.it._classwork_.jd02_06;

public class Client {


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                Log logger = Logger.getLog();
                logger.error("bad event");
                logger.info("test");
            }).start();
        }
    }

}

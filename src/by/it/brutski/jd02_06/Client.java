package by.it.brutski.jd02_06;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Log logger = Logger.getLog();
                logger.error("bad event");
                logger.info("text");
            }).start();
        }
    }
}

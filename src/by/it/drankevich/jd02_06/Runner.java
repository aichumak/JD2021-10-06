package by.it.drankevich.jd02_06;

public class Runner {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log logger = Logger.getLog();
                logger.info("test");
                logger.error("bad event");
            }

        };
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(runnable);
            thread.start();
        }

    }
}

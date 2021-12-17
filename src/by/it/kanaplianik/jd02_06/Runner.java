package by.it.kanaplianik.jd02_06;



public class Runner {
    public static void main (String [] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                Log logger = LogToFile.instance();
                logger.error("ошибочка вышла");
                logger.info("информация");
            }).start();
        }

    }
}

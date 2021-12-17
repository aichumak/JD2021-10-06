package by.it.chumak.jd02_06;

import by.it.chumak.jd02_06.model.ResourceManager;
import by.it.chumak.jd02_06.service.Logger;
import by.it.chumak.jd02_06.service.LoggerMethods;

public class Client {

    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                LoggerMethods logger = Logger.getLog();
                logger.error("important mistake", resourceManager.getZonedDateTime());
                logger.info("important message", resourceManager.getZonedDateTime());
            }).start();
        }
    }

}

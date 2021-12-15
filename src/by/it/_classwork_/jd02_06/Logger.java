package by.it._classwork_.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements Log {

    private static volatile Log logger;
    private final String path;

    private Logger() {
        path = Filenames.getFullPath("log.txt", Logger.class);
    }

    public static Log getLog() {
        Log localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    logger = localLogger;
                }
            }
        }
        return localLogger;
    }


    private synchronized void log(String type, String message) {
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(path, true))
        ) {
            writer.printf("TYPE: %s message: %s%n", type, message);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String message) {
        log("ERROR", message);
    }

    @Override
    public void info(String message) {
        log("INFO", message);
    }
}

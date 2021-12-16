package by.it.drankevich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Log {

    private static volatile Log logger;
    private final String path;

    private Logger() {
        path = Filenames.getFullPath(Logger.class, "log.txt");
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            String dateTime= LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            writer.printf("TYPE: %s   message: %s   Date/Time:%s%n", type, message,dateTime);
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
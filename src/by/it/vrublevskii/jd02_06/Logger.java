package by.it.vrublevskii.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Logger implements Log {

    final static Object monitor = new Object();
    private static volatile Log logger;
    String fullPath;
    String moment;


    private Logger() {
        fullPath = FileNames.getFullPath("log.txt", Logger.class);
    }

    public static Log getLog() {
        Log localLogger = logger;
        if (localLogger == null) {
            synchronized (monitor) {
                localLogger = logger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    logger = localLogger;
                }
            }
        }
        return localLogger;
    }

    private synchronized void log(String type, String message, String moment) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fullPath, true))) {
            printWriter.printf("TYPE: %-8s message: %-8s%s\n", type, message, moment);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getErrorMoment(){
        Instant now = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of("GMT+3"));
        DateTimeFormatter ru = DateTimeFormatter.ofPattern("HH.mm.ss dd.MM.yyyy г.", new Locale("ru"));
        moment = ru.format(zonedDateTime);
    }

    @Override
    public void error(String message) {
        log("error ", message, moment);
    }

    @Override
    public void info(String message) {
        log("info ", message, moment);
    }
}

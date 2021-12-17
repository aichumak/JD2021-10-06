package by.it.chumak.jd02_06.service;

import by.it.chumak.jd02_06.model.MessageType;
import by.it.chumak.jd02_06.model.GetPathMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements LoggerMethods {

    private static volatile LoggerMethods logger;
    private final String path;

    private Logger() {
        GetPathMethod getPathMethods = new GetPathMethod();
        path = getPathMethods.getFilePath(Logger.class, "log.txt");
    }

    public static LoggerMethods getLog() {
        LoggerMethods localLogger = Logger.logger;
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

    private synchronized void log(MessageType type, String message, String zonedDateTime) {
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(path, true))
        ) {
            writer.printf("Type: %s, message: %s, %s%n", type, message, zonedDateTime);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String message, String zonedDateTime) {
        log(MessageType.ERROR, message, zonedDateTime);
    }

    @Override
    public void info(String message, String zonedDateTime) {
        log(MessageType.INFO, message, zonedDateTime);
    }
}

package by.it.chumak.calc.service;

import by.it.chumak.calc.ConsoleRunner;
import by.it.chumak.calc.model.GetPathMethod;
import by.it.chumak.calc.constant.MessageType;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger implements LoggerMethods {
    INSTANCE;

    private final String path = new GetPathMethod().getFilePath(ConsoleRunner.class, "log.txt");

    Logger() {
    }

    private void log(MessageType type, String message, String zonedDateTime) {
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

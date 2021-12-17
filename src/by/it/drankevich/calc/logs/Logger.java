package by.it.drankevich.calc.logs;

import by.it.drankevich.calc.exeption.CalcExeption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Log {

    private static volatile Log logger;
    private final String path;

    private Logger() {
        path = Filenames.getFullPath(Logger.class, "log.txt");
    }


    private static class LoggerHolder {
        public static final Log loggerHolder = new Logger();
    }

    public static Log getLogger() {
        return LoggerHolder.loggerHolder;
    }


    private synchronized void log(String type, String message, LogCreator logBuilderShort, LogCreator logBuilderFull) throws CalcExeption {
        logBuilderFull.Creator(type, message);
        logBuilderShort.Creator(type, message);

        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
           
            writer.printf(" %s   %s   Date/Time:%s%n", type, message, dateTime);
            writer.flush();
        } catch (IOException e) {
            throw new CalcExeption(e);
        }
    }

    @Override
    public void error(String message, LogCreator logBuilderShort, LogCreator logBuilderFull) throws CalcExeption {

        log("ERROR", message, logBuilderShort, logBuilderFull);
    }

    @Override
    public void info(String message, LogCreator logBuilderShort, LogCreator logBuilderFull) throws CalcExeption {
        log("INFO", message, logBuilderShort, logBuilderFull);
    }
}
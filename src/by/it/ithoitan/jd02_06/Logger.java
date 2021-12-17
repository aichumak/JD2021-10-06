package by.it.ithoitan.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Необходимо создать логгер выводящий сообщения об ошибках и событиях в текстовый файл.
Объект логгера должен быть создан с помощью шаблона проектирования Singleton (ленивый
и потокобезопасный – на lock-ах). Он должен имплементировать интерфейс Log с методами
error(сообщения об ошибке) и info(сообщение) и записывающий его в файл вместе с
информацией о типе, дате, времени и тексте происшествия. Файл имеет имя log.txt и
располагается в том же каталоге, что и исходный код класса Singleton.
 */
public class Logger implements Log {
    private static volatile Logger logger;

    private final String path;

    public Logger() {
        path = Filenames.getPath("log.txt", Logger.class);
    }

    public static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

    private synchronized void log(String type, String message) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(path, true))) {
            printWriter.printf("TYPE: %s message: %s%n", type, message);
            printWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFormat() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return now.format(formatter);
    }

    @Override
    public void error(String message) {
        String format = getFormat();
        log("ERROR", message + " " + format);

    }

    @Override
    public void info(String message) {
        String format = getFormat();
        log("INFO", message + " " + format);
    }
}

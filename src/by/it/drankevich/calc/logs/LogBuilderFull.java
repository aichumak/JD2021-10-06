package by.it.drankevich.calc.logs;

import by.it.drankevich.calc.ResourceManager;
import by.it.drankevich.calc.exeption.CalcExeption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogBuilderFull implements LogCreator{
    @Override
    public void Creator(String type, String message) throws CalcExeption {
        String  path = Filenames.getFullPath(Logger.class, "logFull.txt");


        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            if (message.equals(ResourceManager.get("massage.Report"))){
                writer.printf("%sFull%n   Date/Time:%s%n", message, dateTime);
            }
            else
            if (message.equals(ResourceManager.get("massage.CalcClosed"))){
                writer.printf("%s%n   Date/Time:%s%n", message, dateTime);
            }
            else
            writer.printf("%s   %s%n", type, message);
            writer.flush();
        } catch (IOException e) {
            throw new CalcExeption(e);
        }
    }

}



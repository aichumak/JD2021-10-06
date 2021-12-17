package by.it.drankevich.calc.logs;

import by.it.drankevich.calc.ResourceManager;
import by.it.drankevich.calc.exeption.CalcExeption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogBuilderShort implements LogCreator{
    @Override
    public void Creator(String type, String message) throws CalcExeption {

      String  path = Filenames.getFullPath(Logger.class, "logShort.txt");


        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm"));
            if (type.equals("ERROR")){
                writer.printf("%s%n", type);
            }
            else
            if (message.equals(ResourceManager.get("massage.Report"))){
                writer.printf("%sShort%n   Date/Time:%s%n", message, dateTime);
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


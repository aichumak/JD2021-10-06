package by.it.astapchik.jd02_05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    public static void printResult(ResourceManager language, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(Messages.SENTENCE));
        System.out.println(language.get(User.FIRSTNAME));
        System.out.println(language.get(User.LASTNAME));
        System.out.println(dateTimeFormatter.format(localDateTime));
    }
}

package by.it.laevskiy.jd02_05;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static by.it.laevskiy.jd02_05.Messages.*;
import static by.it.laevskiy.jd02_05.User.*;


public class Runner {

    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("GMT+3"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("If you want to bow out - type end");
            System.out.println("Type the language");
            String language = scanner.nextLine();

            if (language.equalsIgnoreCase(Messages.STOP_APP_COMMAND)) {
                break;
            } else {
                Locale locale = new Locale(language);
                lang.setLocale(locale);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN_TIME,locale);
                String stringTime = dateTimeFormatter.format(zonedDateTime);
                System.out.printf("%s\n%s\n%s %s %s\n%s\n\n",
                        lang.get(WELCOME),
                        lang.get(QUESTION),
                        lang.get(SENTENCE),
                        lang.get(FIRST_NAME),
                        lang.get(LAST_NAME),
                        stringTime);
            }
        }
    }
}
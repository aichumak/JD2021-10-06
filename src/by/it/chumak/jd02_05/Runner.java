package by.it.chumak.jd02_05;

import by.it.chumak.jd02_05.model.*;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateFormatPatterns.TIME_DATE, lang.getLocale());
        CountryEntity countryEntity = new CountryEntity();
        Scanner scanner = new Scanner(System.in);
        String line = "";

        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.setLocale(locale);
        }

        printMessages(lang, dateTimeFormatter);

        while (!line.equals("end")) {
            line = scanner.nextLine();
            if (line.equals("ru") || line.equals("be") || line.equals("en")) {
                Locale locale = new Locale(line, countryEntity.getCountryCodeAlfa2(line));
                lang.setLocale(locale);
            }
            printMessages(lang, dateTimeFormatter);
        }
    }

    private static void printMessages(ResourceManager lang, DateTimeFormatter dateTimeFormatter) {
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(Messages.SENTENCE));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(dateTimeFormatter.format(lang.getZonedDateTime()));
    }
}

package by.it.astapchik.jd02_05;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Date {
    public static final String DATE_FORMAT = "dd-MMM-yyyy HH:mm:ss";
    public static DateTimeFormatter getTime(ResourceManager language, String DATE_FORMAT, Scanner input, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please select locale to see time: ");
        switch (input.nextLine()) {

            case "ru": {
                language.setLocale(new Locale("ru", "RU"));
                dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.forLanguageTag("ru"));
                break;
            }
            case "be": {
                language.setLocale(new Locale("be", "BY"));
                dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.forLanguageTag("be"));
                break;
            }
            case "de": {
                language.setLocale(new Locale("de", "DE"));
                dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.forLanguageTag("de"));
                break;
            }
            case "en": {
                language.setLocale(new Locale("en", "US"));
                dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.forLanguageTag("en"));
                break;
            }
        }
        return dateTimeFormatter;
    }

}

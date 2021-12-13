package by.it.vrublevskii.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        Date date = getDate(lang);
        String next = getInputString();
        Locale locale = getLocale(next);
        lang.setLocale(locale);
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(Messages.SENTENCE));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(dateInstance.format(date));
    }

    private static Date getDate(ResourceManager lang) {
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("en","GB"));
        Date date = null;
        try {
            date = dateInstance.parse(lang.get(by.it.vrublevskii.jd02_05.Date.CURRENT_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Locale getLocale(String next) {
        Locale locale;
        if (next.equals("ru")) {
            locale = new Locale("ru", "RU");
        } else if (next.equals("be")) {
            locale = new Locale("be", "BY");
        } else {
            locale = new Locale("en", "GB");
        }
        return locale;
    }
}


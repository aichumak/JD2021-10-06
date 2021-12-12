package by.it.drankevich.jd02_05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = null;

        Scanner sc = new Scanner(System.in);


        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.setLocale(locale);
            dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag(args[0]));

        } else {
            System.out.println("Выберите язык : en,be,ru и нажмите Enter\n Для вывода языка по умолчанию Enter");

            switch (sc.nextLine()) {

                case "ru":
                    lang.setLocale(new Locale("ru", "RU"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("ru"));
                    break;

                case "be":
                    lang.setLocale(new Locale("be", "BY"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("be"));
                    break;

                default:
                    lang.setLocale(new Locale("en"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("en"));
                    break;

            }
        }
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(Messages.SENTENCE));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
    }
}

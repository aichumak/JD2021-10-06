package by.it.konon.jd02_05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        ResourceManager instance = ResourceManager.INSTANCE;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy",
                Locale.forLanguageTag(args[0]));


        Scanner scanner = new Scanner(System.in);
        String line = "";


        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            instance.setLocale(locale);
            dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy",
                    Locale.forLanguageTag(args[0]));

        } else {
            System.out.println("Choose language format:");
        }


        while (!line.equals("end")) {
            switch (scanner.nextLine()) {
                case "ru": {
                    instance.setLocale(new Locale("ru", "RU"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy",
                            Locale.forLanguageTag("ru"));
                    break;
                }

                case "be": {
                    instance.setLocale(new Locale("be", "BY"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy",
                            Locale.forLanguageTag("be"));
                    break;

                }
                case "en": {
                    instance.setLocale(new Locale("en", "EN"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy",
                            Locale.forLanguageTag("en"));
                    break;

                }
                case "": {
                    instance.setLocale(new Locale("en", "EN"));
                    dateTimeFormatter = DateTimeFormatter.ofPattern("hh.mm dd.MM.yyyy");
                    break;
                }
                case "end": {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Incorrect language format!\nChoose language format:");
                    scanner.nextLine();
                    break;
                }
            }
            System.out.println(dateTimeFormatter.format(localDateTime));
            System.out.println(instance.get(Messages.WELCOME));
            System.out.println(instance.get(Messages.QUESTION));
            System.out.println(instance.get(Messages.SENTENCE));
            System.out.println(instance.get(User.FIRST_NAME));
            System.out.println(instance.get(User.LAST_NAME));


        }
    }

}

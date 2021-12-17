package by.it.serkutsyev.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourseManager languages = ResourseManager.INSTANCE;
        if (args.length==2) {
            Locale locale = new Locale(args[0], args[1]);
            languages.setLocale(locale);
        }

        System.out.println(languages.get(Messages.WELCOME));
        System.out.println(languages.get(Messages.QUESTION));
        System.out.println(languages.get(Messages.SENTENCE));
        System.out.println(languages.get(User.NAME));
        System.out.println(languages.get(User.SURNAME));
    }

}

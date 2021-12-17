package by.it.kanaplianik.jd02_05;

import java.util.Locale;

public class Runner {
   public static void main(String[] args) {

        ManagerOfResources lang = ManagerOfResources.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.setLocale(locale);
        }

        System.out.println(lang.get(MessageText.WELCOME));
        System.out.println(lang.get(User.I_WORD));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(MessageText.QUESTION));
        System.out.println(lang.get(MessageText.ANSWER));

    }
}

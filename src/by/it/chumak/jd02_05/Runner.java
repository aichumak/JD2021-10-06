package by.it.chumak.jd02_05;

import by.it.chumak.jd02_05.model.Messages;
import by.it.chumak.jd02_05.model.ResourceManager;
import by.it.chumak.jd02_05.model.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            lang.setLocale(locale);
        }
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(Messages.SENTENCE));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
    }
}

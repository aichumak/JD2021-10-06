package by.it.astapchik.jd02_05;

import java.util.Locale;

class Runner {
    public static void main(String[] args) {
        ResourceManager language = ResourceManager.INSTANCE;
        if (args.length == 2){
            Locale locale = new Locale(args[0], args[1]);
            language.setLocale(locale);
        }

        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(Messages.SENTENCE));
        System.out.println(language.get(User.FIRSTNAME));
        System.out.println(language.get(User.LASTNAME));

    }
}

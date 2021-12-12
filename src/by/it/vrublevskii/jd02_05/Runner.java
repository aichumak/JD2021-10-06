package by.it.vrublevskii.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Locale locale;
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.equals("ru")){
            locale = new Locale("ru", "RU");
        }else if (next.equals("be")){
            locale = new Locale("be", "BY");
        }else{
            locale = new Locale("en", "GB");
        }
        ResourceBundle bundle = ResourceBundle.getBundle("by.it.vrublevskii.jd02_05.language.strings", locale);
        System.out.println(bundle.getString("messages.welcome"));
        System.out.println(bundle.getString("messages.question"));
        System.out.println(bundle.getString("messages.sentence"));
        System.out.println(bundle.getString("user.firstname"));
        System.out.println(bundle.getString("user.lastname"));


//            ResourceManager lang = ResourceManager.INSTANCE;
//            if (args.length == 2){
//                Locale locale = new Locale(args[0], args[1]);
//                lang.setLocale(locale);
//            }
//            System.out.println(lang.get(Messages.WELCOME));
//            System.out.println(lang.get(Messages.QUESTION));
//            System.out.println(lang.get(Messages.SENTENCE));
//            System.out.println(lang.get(User.FIRST_NAME));
//            System.out.println(lang.get(User.LAST_NAME));
//
    }
}


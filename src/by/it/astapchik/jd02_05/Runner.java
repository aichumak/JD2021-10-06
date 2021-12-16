package by.it.astapchik.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

class Runner {
    public static void main(String[] args) {

        Date date = null;
        DateFormat dateFormat = DateFormat.getDateInstance();

        long millis = System.currentTimeMillis();
        java.util.Date date1 = new java.util.Date(millis);
        String str = date1.toString();

        ResourceManager language = ResourceManager.INSTANCE;

        if (args.length == 2){
            Locale locale = new Locale(args[0], args[1]);
            language.setLocale(locale);
            if (args[1] == "DE"){
                locale = Locale.GERMAN;
            }
            if (args[1] == "RU"){
                locale = new Locale("ru", "RU");
            }

            if (args[1] == "US"){
                locale = Locale.US;
            }


            dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);



            try {
                date = dateFormat.parse(str);
                System.out.println(date);
            } catch (ParseException e) {
                System.err.print("Error position: " + e.getErrorOffset());
            }
        }

        System.out.println("Current date: " + str);


        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(Messages.SENTENCE));
        System.out.println(language.get(User.FIRSTNAME));
        System.out.println(language.get(User.LASTNAME));

//        System.out.println("Current date: " + dateFormat.format(date));

    }
}

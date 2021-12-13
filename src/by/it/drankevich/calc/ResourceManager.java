package by.it.drankevich.calc;

import java.util.Locale;
import java.util.ResourceBundle;


    public class ResourceManager {

        public static final String basename = "by.it.drankevich.calc.languages.error";

        private static ResourceBundle resourceBundle;

        ResourceManager() {
            setLocale(Locale.getDefault());
        }

       static void setLocale(Locale locale) {
            resourceBundle = ResourceBundle.getBundle(basename, locale);
        }

        public static String get(String key) {
            return resourceBundle.getString(key);
        }


    }


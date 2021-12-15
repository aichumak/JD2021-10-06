package by.it.drankevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.drankevich.jd02_05.languages.strings";

    private static ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("en"));
    }

    public static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public static String get(String key) {
        return resourceBundle.getString(key);
    }


}

package by.it.brutski.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.brutski.jd02_05.language.strings";

    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("en"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}

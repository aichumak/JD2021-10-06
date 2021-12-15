package by.it.kanaplianik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ManagerOfResources {
    INSTANCE;

    public static final String basename = "by.it.kanaplianik.jd02_05.language.strings";

    private ResourceBundle resourceBundle;

    ManagerOfResources() {
        setLocale(new Locale("en", "US"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}

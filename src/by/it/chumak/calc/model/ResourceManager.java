package by.it.chumak.calc.model;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.chumak.calc.language.strings";
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResourceManager() {
        setLocale(new Locale("en", "EN"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        this.locale = locale;
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public Locale getLocale() {
        return locale;
    }
}

package by.it.konon.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;
    private Locale locale;

    public static final String basename = "by.it.konon.jd02_05.language.strings";

    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("en"));

    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        this.locale = locale;
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public Locale getLocale(){
        return locale;
    }
}

package by.it.astapchik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    public static final String basename = "by.it.astapchik.jd02_05.stringsResource.strings";

    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("ru"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}

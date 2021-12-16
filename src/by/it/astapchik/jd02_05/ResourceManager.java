package by.it.astapchik.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    public static final String BASENAME = "by.it.astapchik.jd02_05.stringsResource.strings";
    private Locale locale;
    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("ru", "RU"));
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.resourceBundle = ResourceBundle.getBundle(BASENAME, this.locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}


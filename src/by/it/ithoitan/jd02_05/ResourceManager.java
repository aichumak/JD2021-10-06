package by.it.ithoitan.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    public static final String baseName = "by.it.ithoitan.jd02_05.language.string" ;
    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(new Locale("en"));
    }
    public void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}


package by.it.vrublevskii.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.vrublevskii.jd02_05.language.strings";

    private Locale locale;

    private ResourceBundle resourceBundle;

    ResourceManager(){
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale){
        this.locale =locale;
        this.resourceBundle = ResourceBundle.getBundle(basename, this.locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}

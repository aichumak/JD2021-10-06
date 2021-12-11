package by.it.chumak.jd02_05.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.chumak.jd02_05.language.strings";
    private ResourceBundle resourceBundle;
    private Locale locale;

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

    public ZonedDateTime getZonedDateTime() {
        ZoneIdEntity zoneIdEntity = new ZoneIdEntity();
        return ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zoneIdEntity.getZoneId(locale.getCountry())));
    }

    public Locale getLocale() {
        return locale;
    }
}

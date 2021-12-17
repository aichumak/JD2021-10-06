package by.it.chumak.calc.model;

import by.it.chumak.calc.constant.DateFormatPatterns;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String basename = "by.it.chumak.calc.language.strings";
    private ResourceBundle resourceBundle;
    private Locale locale;
    private ZoneIdEntity zoneIdEntity;

    ResourceManager() {
        setLocale(new Locale("en", "EN"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        this.locale = locale;
        zoneIdEntity = new ZoneIdEntity();
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getZonedDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateFormatPatterns.TIME_DATE, locale);
        return dateTimeFormatter.format(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zoneIdEntity.getZoneId(locale.getCountry()))));
    }

    public String getZonedDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateFormatPatterns.DATE, locale);
        return dateTimeFormatter.format(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zoneIdEntity.getZoneId(locale.getCountry()))));
    }
}

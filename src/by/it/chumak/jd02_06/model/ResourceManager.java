package by.it.chumak.jd02_06.model;

import by.it.chumak.jd02_05.model.ZoneIdEntity;
import by.it.chumak.jd02_06.model.DateFormatPatterns;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public enum ResourceManager {
    INSTANCE;

    private final Locale locale;
    private final ZoneIdEntity zoneIdEntity;
    private final Instant instant;
    private final DateTimeFormatter dateTimeFormatter;

    ResourceManager() {
        locale = new Locale("en", "EN");
        zoneIdEntity = new ZoneIdEntity();
        instant = Instant.now();
        dateTimeFormatter = DateTimeFormatter.ofPattern(DateFormatPatterns.TIME_DATE, locale);
    }

    public String getZonedDateTime() {
        return dateTimeFormatter.format(ZonedDateTime.ofInstant(instant, ZoneId.of(zoneIdEntity.getZoneId(locale.getCountry()))));
    }

}

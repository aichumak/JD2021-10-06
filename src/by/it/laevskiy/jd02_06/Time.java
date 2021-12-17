package by.it.laevskiy.jd02_06;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Time {
    public Time() {
    }

    public static String getTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime
                .ofInstant(Instant.now(), ZoneId.of("GMT+3"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("HH.mm.ss dd.MM.yyyy г.", new Locale("ru"));
        return dateTimeFormatter.format(zonedDateTime);
    }
}

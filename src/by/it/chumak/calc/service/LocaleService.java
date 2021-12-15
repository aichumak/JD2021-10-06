package by.it.chumak.calc.service;

import java.util.Locale;

public class LocaleService {
    private final Locale locale;

    public LocaleService() {
        this.locale = setLocale(Locale.getDefault().getLanguage());
    }

    public Locale getLocale() {
        return locale;
    }

    public Locale getLocale(String expression) {
        return setLocale(expression);
    }

    private Locale setLocale(String languageLetterCode) {
        return switch (languageLetterCode) {
            case "ru" -> new Locale("ru", "RU");
            case "be" -> new Locale("be", "BE");
            default -> new Locale("en", "EN");
        };
    }

}

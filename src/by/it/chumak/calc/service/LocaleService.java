package by.it.chumak.calc.service;

import java.util.Locale;

public class LocaleService {
    private final Locale locale;

    public LocaleService(String languageLetterCode) {
        this.locale = setLocale(languageLetterCode);
    }


    public Locale getLocale() {
        return locale;
    }

    public Locale getLocale(String expression) {
        return setLocale(expression);
    }

    private Locale setLocale(String languageLetterCode) {
        if (languageLetterCode.equals("en")) {
            return new Locale("en", "EN");
        } else if (languageLetterCode.equals("ru")) {
            return new Locale("ru", "RU");
        } else if (languageLetterCode.equals("be")) {
            return new Locale("be", "BE");
        } else {
            return new Locale("en", "EN");
        }
    }

}

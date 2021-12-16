package by.it.chumak.jd02_05.model;

public class CountryEntity {

    public String getCountryCodeAlfa2(String languageCode) {
        return switch (languageCode) {
            case "en" -> "EN";
            case "ru" -> "RU";
            case "be" -> "BY";
            default -> "";
        };
    }
}

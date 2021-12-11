package by.it.chumak.jd02_05.model;

public class CountryEntity {

    public String getCountryCodeAlfa2(String languageCode) {
        if (languageCode.equals("en")) {
            return "EN";
        } else if (languageCode.equals("ru")) {
            return "RU";
        } else if (languageCode.equals("be")) {
            return "BY";
        }
        return "";
    }
}

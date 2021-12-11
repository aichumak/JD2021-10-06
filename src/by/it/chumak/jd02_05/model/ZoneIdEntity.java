package by.it.chumak.jd02_05.model;

public class ZoneIdEntity {

    public String getZoneId(String country) {
        if (country == "BY") {
            return "Europe/Minsk";
        } else if (country == "EN") {
            return "Europe/London";
        } else if (country == "RU") {
            return "Europe/Moscow";
        }
        return "";
    }
}

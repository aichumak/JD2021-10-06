package by.it.chumak.calc.model;

public class ZoneIdEntity {
    public String getZoneId(String country) {
        return switch (country) {
            case "BY" -> "Europe/Minsk";
            case "EN" -> "Europe/London";
            case "RU" -> "Europe/Moscow";
            default -> "";
        };
    }
}

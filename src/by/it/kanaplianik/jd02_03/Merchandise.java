package by.it.kanaplianik.jd02_03;

public class Merchandise {
    private final Cost price;
    private final String name;

    public Merchandise(String name, Cost price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {

        return name;
    }



}

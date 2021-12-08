package by.it.kanaplianik.jd02_01.Models;

public class Good {
    private final Price price;
    private final String name;

    public Good(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {

        return name;
    }



}

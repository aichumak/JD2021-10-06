package by.it.vrublevskii.jd02_01.entity;

public class Good {

    private final String name;
    private final double price;

    public Good() {
        this.name = "something";
        this.price = 12d;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ", price=" + price;
    }
}

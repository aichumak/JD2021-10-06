package by.it.chumak.jd02_01.entity;

public class Good {

    private final String name;
    private final double price;

    public Good() {
        this("noname", 0);
    }

    public Good(String customerName, double itemPrice) {
        this.name = customerName;
        this.price = itemPrice;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

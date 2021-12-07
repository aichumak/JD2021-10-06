package by.it.konon.jd02_01.entity;

public class Good {

    private final String name;
    private final double price;

    @SuppressWarnings("unused")
    public Good() {
        this("no name", 0);
    }

    public Good(String goodsName, double goodsPrice) {
        this.name = goodsName;
        this.price = goodsPrice;
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

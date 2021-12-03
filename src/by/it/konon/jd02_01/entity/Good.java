package by.it.konon.jd02_01.entity;

import by.it.konon.jd02_01.PriceListRepo;

import java.util.HashMap;

public class Good extends PriceListRepo {

    private final String name;
    private final double price;



    @Override
    public HashMap<String, Double> getHashMap() {
        return super.getHashMap();
    }


    public Good() {
        this("noname", 0);
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
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

package by.it.chumak.jd02_01.entity;

public class Good {

    private final String goodsName;
    private final double goodsPrice;

    public Good() {
        this("noname", 0);
    }

    public Good(String goodsName, double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }


    public String getName() {
        return goodsName;
    }

    public double getPrice() {
        return goodsPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + goodsName + '\'' +
                ", price=" + goodsPrice +
                '}';
    }

}

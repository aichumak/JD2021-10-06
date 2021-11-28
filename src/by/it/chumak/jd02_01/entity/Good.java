package by.it.chumak.jd02_01.entity;

public class Good {

    private final Customer customer;
    private final String goodsName;
    private final double goodsPrice;

    public Good() {
        this(new Customer() ,"noname", 0);
    }

    public Good(Customer customer, String goodsName, double goodsPrice) {
        this.customer = customer;
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

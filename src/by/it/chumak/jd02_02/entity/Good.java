package by.it.chumak.jd02_02.entity;

public class Good {

    private final String goodsName;

    public Good(String goodsName, double goodsPrice) {
        this.goodsName = goodsName;
    }

    public String getName() {
        return goodsName;
    }

}

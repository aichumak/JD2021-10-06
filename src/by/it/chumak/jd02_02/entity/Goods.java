package by.it.chumak.jd02_02.entity;

public class Goods {

    private final String[] GOODS;

    public Goods() {
        this.GOODS = new String[]{"bread", "loaf", "milk", "yogurt", "water", "fish", "chicken", "meat", "chips", "candy", "sugar", "flour", "rice", "fruit", "salad", "cake", "cola"};
    }

    public String[] getGoods() {
        return this.GOODS;
    }
}

package by.it.vrublevskii.jd02_03.entity;


import java.util.ArrayList;

public class ShoppingCart {

    private
    ArrayList<Good> goodsInCart = new ArrayList<>();

    private int numberGoodsInCart = 0;
    private double priceTotal = 0;

    public ShoppingCart() {
    }

    public ArrayList<Good> getGoodsInCart() {
        return goodsInCart;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void add(Good good) {
        goodsInCart.add(good);
        numberGoodsInCart++;
        priceTotal += good.getPrice();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "goodsInCart=" + goodsInCart +
                ", numberGoodsInCart=" + numberGoodsInCart +
                '}';
    }
}

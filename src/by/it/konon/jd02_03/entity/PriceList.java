package by.it.konon.jd02_03.entity;

import by.it.konon.jd02_03.helper.RandomGenerator;

import java.util.HashMap;

public class PriceList {

    private final HashMap<String, Integer> priceLIst;

    public PriceList() {
        String[] arrayItems = new Goods().getGoods();
        this.priceLIst = new HashMap<>();

        for (String item : arrayItems) {
            this.priceLIst.put(item, RandomGenerator.get(1, 5));
        }
    }

    public HashMap<String, Integer> getPriceList() {
        return this.priceLIst;
    }

}

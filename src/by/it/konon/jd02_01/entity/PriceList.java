package by.it.konon.jd02_01.entity;

import by.it.konon.jd02_01.helper.RandomGenerator;

import java.util.HashMap;

public class PriceList {

    private final HashMap<String, Integer> priceList;

    public PriceList() {
        String[] arrayItems = new Goods().getGoods();
        priceList = new HashMap<>();

        for (String item : arrayItems) {
            priceList.put(item, RandomGenerator.get(1, 5));
        }
    }

    public HashMap<String, Integer> getPriceList() {
        return priceList;
    }

}

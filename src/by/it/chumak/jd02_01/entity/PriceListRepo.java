package by.it.chumak.jd02_01.entity;

import by.it.chumak.jd02_01.helper.RandomGenerator;

import java.util.HashMap;

public class PriceListRepo {

    private final HashMap<String, Integer> priceList;

    public PriceListRepo() {
        String[] arrayItems = new Goods().getGoods();
        priceList = new HashMap<>();

        for (String item : arrayItems) {
            priceList.put(item, RandomGenerator.get(1, 100));
        }
    }

    public HashMap<String, Integer> getPriceList() {
        return priceList;
    }
}

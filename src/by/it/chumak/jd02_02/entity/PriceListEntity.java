package by.it.chumak.jd02_02.entity;

import by.it.chumak.jd02_02.helper.RandomGenerator;

import java.util.HashMap;

public class PriceListEntity {

    private final HashMap<String, Integer> priceList;

    public PriceListEntity() {
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

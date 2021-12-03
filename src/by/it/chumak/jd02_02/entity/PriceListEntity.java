package by.it.chumak.jd02_02.entity;

import by.it.chumak.jd02_02.helper.RandomGenerator;

import java.util.HashMap;

public class PriceListEntity {

    private final HashMap<String, Integer> PRICE_LIST;

    public PriceListEntity() {
        String[] arrayItems = new Goods().getGoods();
        this.PRICE_LIST = new HashMap<>();

        for (String item : arrayItems) {
            this.PRICE_LIST.put(item, RandomGenerator.get(1, 50));
        }
    }

    public HashMap<String, Integer> getPriceList() {
        return this.PRICE_LIST;
    }

}

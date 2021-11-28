package by.it.chumak.jd02_01.entity;

import by.it.chumak.jd02_01.helper.RandomGenerator;

import java.util.HashMap;

public class PriceListRepo {

    private HashMap<String, Integer> priceList;

    public PriceListRepo() {
        String[] arrayItems = new Goods().getItems();
        priceList = new HashMap<>();

        for (String item : arrayItems) {
            priceList.put(item, RandomGenerator.get(1, 100));
        }

        this.priceList = priceList;
    }

    public HashMap<String, Integer> getPriceList() {
        return priceList;
    }
}

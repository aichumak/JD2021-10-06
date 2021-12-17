package by.it.astapchik.jd02_01.service;
import by.it.astapchik.jd02_01.entity.Good;

import java.util.*;

public class PriceListRepo {

    HashMap<String, Double> listOfFood = new HashMap<String, Double>();{
        listOfFood.put("milk", 1.0);
        listOfFood.put("beer", 2.0);
        listOfFood.put("meat", 3.0);
        listOfFood.put("chicken", 4.0);
        listOfFood.put("biscuit", 5.0);
        listOfFood.put("bread", 6.0);
    }

    static Good selectGood() {
        PriceListRepo priceListRepo = new PriceListRepo();
        Good random = null;
        List<Map.Entry<String, Double>> listOfGoods = new ArrayList<Map.Entry<String, Double>>(
                priceListRepo.listOfFood.entrySet()
        );
        Collections.shuffle(listOfGoods);
        for (Map.Entry<String, Double> good : listOfGoods) {
            random = new Good(good.getKey(), good.getValue());
        }
        return random;
    }
}

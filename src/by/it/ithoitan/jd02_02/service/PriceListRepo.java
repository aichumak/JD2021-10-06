package by.it.ithoitan.jd02_02.service;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo extends Thread {
    Map<String,Double> priceList = new HashMap<>();

    public PriceListRepo(Map<String, Double> priceList) {
        this.priceList = priceList;
    }


}

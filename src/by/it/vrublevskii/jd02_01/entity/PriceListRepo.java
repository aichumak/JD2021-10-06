package by.it.vrublevskii.jd02_01.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class PriceListRepo {

    private static HashMap<String, Double> priceList = new HashMap<>();

    public PriceListRepo() {
        priceList = fillPriceList();
    }

    public HashMap<String, Double> getPriceList() {
        return priceList;
    }

    @SuppressWarnings("RedundantExplicitVariableType")
    public String getGoodName(int index){
        Set<String> goodsNames = priceList.keySet();
        Object[] goodsNameArray = goodsNames.toArray();
        return String.valueOf(goodsNameArray[index]);
    }

    public double getGoodPrice(int index){
        Collection<Double> values = priceList.values();
        Object[] goodsPrices = values.toArray();
        return (double) goodsPrices[index];
    }

    private static HashMap<String, Double> fillPriceList() {
        priceList.put("Good1", 12.0);
        priceList.put("Good2", 31.0);
        priceList.put("Good3", 5.0);
        priceList.put("Good4", 76.0);
        priceList.put("Good5", 23.0);
        priceList.put("Good6", 11.0);
        priceList.put("Good7", 2.0);
        priceList.put("Good8", 9.0);
        priceList.put("Good9", 16.0);
        priceList.put("Good10", 12.0);
        priceList.put("Good11", 98.0);
        return priceList;
    }



}

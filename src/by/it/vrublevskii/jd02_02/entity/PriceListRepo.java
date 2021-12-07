package by.it.vrublevskii.jd02_02.entity;

import java.util.HashMap;

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
        Object[] goodsNameArray = priceList.keySet().toArray();
        return String.valueOf(goodsNameArray[index]);
    }

    public double getGoodPrice(int index){
        Object[] goodsPrices = priceList.values().toArray();
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

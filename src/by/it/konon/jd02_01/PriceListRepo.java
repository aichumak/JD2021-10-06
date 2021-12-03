package by.it.konon.jd02_01;

import java.util.HashMap;

public class PriceListRepo {

    HashMap<String, Double> hashMap = new HashMap<String ,Double>();

    public void setHashMap(HashMap<String, Double> hashMap) {
        hashMap.put("Milk",1.5);
        hashMap.put("Beer",3.2);
        this.hashMap = hashMap;
    }

    public HashMap<String, Double> getHashMap() {
        return hashMap;
    }
}
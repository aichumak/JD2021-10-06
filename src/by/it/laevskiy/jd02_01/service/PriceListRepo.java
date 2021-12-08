package by.it.laevskiy.jd02_01.service;


import java.util.HashMap;

public class PriceListRepo {
    HashMap<String, Double> priceListRepo = new HashMap<>();

    public HashMap<String, Double> getPriceListRepo() {
        priceListRepo.put("couch",250.0);
        priceListRepo.put("armchair",100.0);
        priceListRepo.put("painting",25.0);
        priceListRepo.put("coffee table",50.0);
        priceListRepo.put("drawer",125.0);
        priceListRepo.put("wardrobe",300.0);
        return priceListRepo;
    }

    @Override
    public String toString() {
        return "PriceListRepo{" +
                priceListRepo +
                '}';
    }

}

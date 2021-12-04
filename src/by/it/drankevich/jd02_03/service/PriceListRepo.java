package by.it.drankevich.jd02_03.service;

import by.it.drankevich.jd02_03.entity.Good;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PriceListRepo {

     Map<String, Double> priseList = new HashMap<>();{

              priseList.put("potato", 4.0);
                priseList.put("tomato", 5.0);
                priseList.put("water", 12.0);
                priseList.put("lemon", 7.0);
                priseList.put("carrot", 9.0);
                 priseList.put("meat", 13.0);
                 priseList.put("eggs", 3.0);

       }
    static Good goodChoise(){
        PriceListRepo priceListRepo = new PriceListRepo();
        Set<Map.Entry<String, Double>> entries = priceListRepo.priseList.entrySet();
          Object[] objects = entries.toArray();
          Random random = new Random();
          Map.Entry<String, Double> randomGood= (Map.Entry<String, Double>) objects[random.nextInt(objects.length)];

          Good randomgood = new Good(randomGood.getKey(),randomGood.getValue());
          return randomgood;
      }



}

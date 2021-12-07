package by.it.vrublevskii.jd02_01.helper;


import by.it.vrublevskii.jd02_01.entity.Good;
import by.it.vrublevskii.jd02_01.entity.PriceListRepo;

public class GoodGenerator {

    private GoodGenerator() {
    }

    public static Good get(PriceListRepo priceListRepo){
        int maxIndex = priceListRepo.getPriceList().size() - 1;
        int index = RandomGenerator.get(0, maxIndex);
        return new Good(priceListRepo.getGoodName(index), priceListRepo.getGoodPrice(index));
    }

}

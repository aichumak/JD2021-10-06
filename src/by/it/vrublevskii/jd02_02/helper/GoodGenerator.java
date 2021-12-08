package by.it.vrublevskii.jd02_02.helper;


import by.it.vrublevskii.jd02_02.entity.PriceListRepo;
import by.it.vrublevskii.jd02_02.entity.Good;

public class GoodGenerator {

    private GoodGenerator() {
    }

    public static Good get(PriceListRepo priceListRepo){
        int maxIndex = priceListRepo.getPriceList().size() - 1;
        int index = RandomGenerator.get(0, maxIndex);
        return new Good(priceListRepo.getGoodName(index), priceListRepo.getGoodPrice(index));
    }

}

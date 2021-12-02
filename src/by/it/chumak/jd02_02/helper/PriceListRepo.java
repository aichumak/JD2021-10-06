package by.it.chumak.jd02_02.helper;

import by.it.chumak.jd02_02.entity.Goods;
import by.it.chumak.jd02_02.entity.PriceListEntity;

public class PriceListRepo {

    private final PriceListEntity priceListEntity;

    public PriceListRepo() {
        this.priceListEntity = new PriceListEntity();
    }

    public String chooseGoodFromPriceList() {
        String[] arrayNamesGoods = new Goods().getGoods();
        return arrayNamesGoods[RandomGenerator.get(0, arrayNamesGoods.length - 1)];
    }


    public double getGoodsPrice(String nameSelectedGood) {
        return priceListEntity.getPriceList().get(nameSelectedGood);
    }
}

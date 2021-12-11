package by.it.konon.jd02_01.helper;

import by.it.konon.jd02_01.entity.Goods;
import by.it.konon.jd02_01.entity.PriceList;

public class PriceListRepo {

    private final PriceList priceListEntity;

    public PriceListRepo() {
        this.priceListEntity = new PriceList();
    }

    public String chooseGoodFromPriceList() {
        String[] arrayNamesGoods = new Goods().getGoods();
        return arrayNamesGoods[RandomGenerator.get(0, arrayNamesGoods.length - 1)];
    }


    public double getGoodsPrice(String nameSelectedGood) {
        return priceListEntity.getPriceList().get(nameSelectedGood);
    }
}

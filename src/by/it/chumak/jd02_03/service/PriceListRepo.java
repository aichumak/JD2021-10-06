package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Goods;
import by.it.chumak.jd02_03.entity.PriceListEntity;
import by.it.chumak.jd02_03.helper.RandomGenerator;

public class PriceListRepo {

    private final PriceListEntity PRICE_LIST_ENTITY;

    public PriceListRepo() {
        this.PRICE_LIST_ENTITY = new PriceListEntity();
    }


    public double getGoodsPrice(String nameSelectedGood) {
        return PRICE_LIST_ENTITY.getPriceList().get(nameSelectedGood);
    }

    public String chooseGoodFromPriceList() {
        String[] arrayNamesGoods = new Goods().getGoods();
        return arrayNamesGoods[RandomGenerator.get(0, arrayNamesGoods.length - 1)];
    }

}

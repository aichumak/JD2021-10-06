package by.it.konon.jd02_01.service;

import by.it.konon.jd02_01.entity.*;
import by.it.konon.jd02_01.helper.PriceListRepo;
import by.it.konon.jd02_01.helper.RandomGenerator;
import by.it.konon.jd02_01.helper.Timeout;

public class CustomerWorker extends Thread implements ShoppingCardAction, CustomerAction {

    private final Customer customer;
    private final CustomerCount customersCountRepo;
    private final PriceListRepo priceListRepo;
    private ShoppingCard shoppingCard;

    public CustomerWorker(Customer customer, CustomerCount customersCountRepo, PriceListRepo priceListRepo) {
        this.customer = customer;
        this.customersCountRepo = customersCountRepo;
        this.priceListRepo = priceListRepo;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGoodsAndPutItToCart();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to Shop ");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose good ");


        String nameSelectedGood = priceListRepo.chooseGoodFromPriceList();
        System.out.println(customer + " finished to choose good ");
        return new Good(nameSelectedGood, priceListRepo.getGoodsPrice(nameSelectedGood));
    }

    @Override
    public void goOut() {
        customersCountRepo.removeCustomer();
        System.out.println(customer + " bought goods " + shoppingCard.getGoodsList()
                                    + " for a total of "
                                    + customer.getTotal()
                                    + " and left the shop ");
    }

    @Override
    public void takeCart() {
        oversleep(100, 300);
        shoppingCard = new ShoppingCard();
        System.out.println(customer + " took the shopping cart ");
    }

    @Override
    public int putToCart(Good good) {
        int goodsQuantity;
        goodsQuantity = RandomGenerator.get(2, 5);

        System.out.println(customer + " put "
                                    + good.getName()
                                    + " into the cart ");

        shoppingCard.addGoodToCart(good, goodsQuantity);

        return goodsQuantity;
    }

    private void chooseGoodsAndPutItToCart() {
        int goodsCounter;
        goodsCounter = RandomGenerator.get(2, 5);


        for (int i = 0; i < goodsCounter; i++) {
            Good good = chooseGood();
            System.out.println(customer + " choose " + good.getName() + " that costs " + good.getPrice());
            shoppingCard.addGoodToCart(good, putToCart(good));
            customer.setTotal(customer.getTotal() + (shoppingCard.getGoodCount(good) * good.getPrice()));
        }
    }

    private void oversleep(int min, int max) {
        int timeout = RandomGenerator.get(min, max);
        Timeout.sleep(timeout);
    }

}

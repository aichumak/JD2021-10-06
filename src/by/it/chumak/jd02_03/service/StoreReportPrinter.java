package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.Store;

import java.util.Map;

public class StoreReportPrinter {
    private final StringBuffer stringBuffer;

    public StoreReportPrinter() {
        this.stringBuffer = new StringBuffer();
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void printHeadTable(){
        stringBuffer.append("╔════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╗\n");
        stringBuffer.append("║   Cashier 1        │   Cashier 2        │   Cashier 3        │   Cashier 4        │   Cashier 5        │  Customers queue   │ Total store profit ║\n");
        stringBuffer.append("╟────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────╢\n");
        System.out.println(stringBuffer);
    }

    public void printStatus(String statusText){
        System.out.printf("║%-146s║%n", statusText);
    }

    public void printCashierStatus(String statusText){
        System.out.printf("║%-146s║%n", statusText);
    }


    public void printCashierReceipt(Store store, int number, Customer customer) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(customer.getName());
        System.out.println();
        stringBuffer.append(" RECEIPT\n");
        stringBuffer.append("-------------------------------\n");
        stringBuffer.append("-------------------------------\n");

        for (Map.Entry<Good, Integer> entry : customer.getShoppingCard().getCart().entrySet()) {
            double goodsPrice = store.getStorePriceList().getGoodsPrice(entry.getKey().getName());
            double goodsCount = customer.getShoppingCard().getGoodCount(entry.getKey());

            stringBuffer.append("*** Good: ");
            stringBuffer.append(entry.getKey().getName());
            stringBuffer.append(", goods price: ");
            stringBuffer.append(goodsPrice);
            stringBuffer.append("$   ");
            stringBuffer.append(goodsCount);
            stringBuffer.append(" * ");
            stringBuffer.append(goodsPrice);
            stringBuffer.append("$ = ");
            stringBuffer.append(goodsCount * goodsPrice);
            stringBuffer.append("$\n");
        }

        stringBuffer.append("-------------------------------\n");
        stringBuffer.append("RECEIPT TOTAL: ");
        stringBuffer.append(customer.getTotal());
        stringBuffer.append("$\n");
        System.out.println(stringBuffer);
    }
}

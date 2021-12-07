package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreReportPrinter {

    public StoreReportPrinter(){};


    public void printHeadTable() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("╔════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╗\n");
        stringBuffer.append("║   Cashier 1        │   Cashier 2        │   Cashier 3        │   Cashier 4        │   Cashier 5        │  Customers queue   │ Total store profit ║\n");
        stringBuffer.append("╟────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────╢");
        System.out.println(stringBuffer);
    }

    public void printStatus(String statusText) {
        System.out.printf("║%-146s║%n", statusText);
    }

    public void printCashierStatus(Store store, int number, String statusText) {
        StringBuffer stringBuffer = new StringBuffer();
        processText(stringBuffer, store, number, statusText, true);
        System.out.println(stringBuffer);
    }

    public void printCashierStatus(Store store, int number, List<String> cashierStatusList) {
        printStatuses(store, number, cashierStatusList);
    }

    public void printCashierReceipt(Store store, int number, Customer customer) {
        List<String> receiptList = new ArrayList<>();

        receiptList.add(customer.getName());
        receiptList.add("-------RECEIPT------");
        receiptList.add("--------------------");

        for (Map.Entry<Good, Integer> entry : customer.getShoppingCard().getCart().entrySet()) {
            double goodsPrice = store.getStorePriceList().getGoodsPrice(entry.getKey().getName());
            double goodsCount = customer.getShoppingCard().getGoodCount(entry.getKey());

            receiptList.add("good: " + entry.getKey().getName());
            receiptList.add("price: " + goodsPrice + "$");
            receiptList.add(goodsCount + "*" + goodsPrice + "$=" + (goodsCount * goodsPrice) + "$");
            receiptList.add("--------------------");
        }

        receiptList.add("--------------------");
        receiptList.add("RECEIPT TOTAL:" + customer.getTotal() + "$");

        printStatuses(store, number, receiptList);
    }

    private void printStatuses(Store store, int number, List<String> receiptList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < receiptList.size(); i++) {
            processText(stringBuffer, store, number, receiptList.get(i), i == receiptList.size() - 1);
        }
        System.out.println(stringBuffer);
    }

    private void processText(StringBuffer stringBuffer, Store store, int number, String statusText, boolean lastLine) {
        if (number == 1) {
            stringBuffer.append(String.format("║%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("║%-20s│", ""));
        }

        if (number == 2) {
            stringBuffer.append(String.format("%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("%-20s│", ""));
        }

        if (number == 3) {
            stringBuffer.append(String.format("%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("%-20s│", ""));
        }

        if (number == 4) {
            stringBuffer.append(String.format("%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("%-20s│", ""));
        }

        if (number == 5) {
            stringBuffer.append(String.format("%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("%-20s│", ""));
        }

        if (lastLine) {
            stringBuffer.append(String.format("%-20d│", store.getQueue().getSize()));
            stringBuffer.append(String.format("%-20f║", store.getTotalProfit()));
        } else {
            stringBuffer.append(String.format("%-20s│", ""));
            stringBuffer.append(String.format("%-20s║%n", ""));
        }
    }
}

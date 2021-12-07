package by.it.chumak.jd02_03.service;

import by.it.chumak.jd02_03.entity.Customer;
import by.it.chumak.jd02_03.entity.Good;
import by.it.chumak.jd02_03.entity.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreReportPrinter {
    private final StringBuffer stringBuffer;

    public StoreReportPrinter() {
        this.stringBuffer = new StringBuffer();
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void printHeadTable() {
        stringBuffer.setLength(0);
        stringBuffer.append("╔════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╗\n");
        stringBuffer.append("║   Cashier 1        │   Cashier 2        │   Cashier 3        │   Cashier 4        │   Cashier 5        │  Customers queue   │ Total store profit ║\n");
        stringBuffer.append("╟────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────╢\n");
        System.out.println(stringBuffer);
    }

    public void printStatus(String statusText) {
        System.out.printf("║%-146s║%n", statusText);
    }

    public void printCashierStatus(Store store, int number, String statusText) {
        stringBuffer.setLength(0);
        processText(store, number, statusText, true);
        System.out.println(stringBuffer);
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

        printReceipt(store, number, customer, receiptList);
    }

    private void printReceipt(Store store, int number, Customer customer, List<String> receiptList) {
        stringBuffer.setLength(0);
        for (int i = 0; i < receiptList.size(); i++) {
            processText(store, number, receiptList.get(i), i == receiptList.size() - 1);
        }
        System.out.println(stringBuffer);
    }

    private void processText(Store store, int number, String statusText, boolean lastLine) {
        if (number == 1) {
            stringBuffer.append(String.format("║%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("║%-20s│", ""));
        }

        if (number == 2) {
            stringBuffer.append(String.format("│%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("│%-20s│", ""));
        }

        if (number == 3) {
            stringBuffer.append(String.format("│%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("│%-20s│", ""));
        }

        if (number == 4) {
            stringBuffer.append(String.format("│%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("│%-20s│", ""));
        }

        if (number == 5) {
            stringBuffer.append(String.format("│%-20s│", statusText));
        } else {
            stringBuffer.append(String.format("│%-20s│", ""));
        }

        if (lastLine) {
            stringBuffer.append(String.format("│%-20d│", store.getQueue().getSize()));
            stringBuffer.append(String.format("│%-20f║%n", store.getTotalProfit()));
        } else {
            stringBuffer.append(String.format("│%-20s│", ""));
            stringBuffer.append(String.format("│%-20s║%n", ""));
        }
    }
}

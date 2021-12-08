package by.it.chumak.bank.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier {
    private final String name;
    private final Bank bank;
    private AtomicInteger cash = new AtomicInteger(300);

    public Cashier(Bank bank, int cashierNumber) {
        this.name = "Cashier #" + cashierNumber;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public double getCash() {
        return cash.get();
    }

    public void addToCash(int amount) {
        cash.getAndAdd(amount);
    }

    public int getFromCash(int amount) {
        if (cash.get() - amount >= 0) {
            cash.getAndAdd(-amount);
            return amount;
        } else {
            return bank.getStorageMoney(amount);
        }
    }

}

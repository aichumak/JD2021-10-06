package by.it.chumak.bank.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private final AtomicInteger moneyStorage = new AtomicInteger(0);
    private final int cashierMaxLimit;
    private final Queue clientDeque;
    private final int countClientsPlan;
    private final List<Cashier> cashiersList;
    private final AtomicInteger clientsIn = new AtomicInteger(0);
    private final AtomicInteger clientsOut = new AtomicInteger(0);

    public Bank(Queue clientDeque, int countClientsPlan, int moneyStorage, int cashierMaxLimit) {
        this.moneyStorage.getAndAdd(moneyStorage);
        this.cashierMaxLimit = cashierMaxLimit;
        this.countClientsPlan = countClientsPlan;
        this.clientDeque = clientDeque;
        this.cashiersList = new ArrayList<>();
    }

    @SuppressWarnings("inverted")
    public boolean bankIsOpen() {
        return clientsOut.get() != countClientsPlan;
    }

    public List<Cashier> getCashiersList() {
        return cashiersList;
    }

    public void addCashierToList(Cashier cashier) {
        this.cashiersList.add(cashier);
    }

    public void addClientsIn() {
        this.clientsIn.getAndIncrement();
    }

    public void addClientsOut() {
        this.clientsOut.getAndIncrement();
    }

    public int getStorageMoney(int amount) {
        if (moneyStorage.get() == 0) {
            return 0;
        } else if (moneyStorage.get() - amount >= 0) {
            moneyStorage.getAndAdd(-amount);
            return amount;
        } else {
            return moneyStorage.getAndAdd(-moneyStorage.get());
        }
    }

    public Queue getClientDeque() {
        return clientDeque;
    }

    public int getCountClientsPlan() {
        return countClientsPlan;
    }

    public void addStorageMoney(int amount) {
        moneyStorage.getAndAdd(amount);
    }

    public double getCashierMaxLimit() {
        return cashierMaxLimit;
    }
}

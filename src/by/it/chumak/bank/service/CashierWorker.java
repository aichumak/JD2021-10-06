package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Cashier;

public class CashierWorker implements Runnable{

    private final Bank bank;
    private final Cashier cashier;

    public CashierWorker(Bank bank, Cashier cashier) {
        this.bank = bank;
        this.cashier = cashier;
    }

    @Override
    public void run() {

    }
}

package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Cashier;

import java.util.List;

public class ManagerWorker implements Runnable {

    private final Bank bank;

    public ManagerWorker(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {

        while (!bank.bankIsClosed()){
            List<Cashier> cashierList = bank.getCashiersList();
            for (Cashier cashier : cashierList) {
                if(cashier.getCash()> bank.getCashierMaxLimit()){
                    bank.addStorageMoney(cashier.getFromCash(300));
                }
            }
        }

    }
}

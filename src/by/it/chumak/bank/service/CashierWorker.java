package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Cashier;
import by.it.chumak.bank.entity.Client;

public class CashierWorker implements Runnable{

    private final Bank bank;
    private final Cashier cashier;

    public CashierWorker(Bank bank, Cashier cashier) {
        this.bank = bank;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        while (!bank.bankIsClosed()){
            Client client = bank.getClientDeque().extract();
            System.out.println(cashier.getName() + " start to service " + client.getClientName());

            for (Enum clientAction : client.getClientActions()) {

            }
        }
    }
}

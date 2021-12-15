package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.*;
import by.it.chumak.bank.helper.RandomGenerator;
import by.it.chumak.bank.helper.Timeout;

public class CashierWorker implements Runnable {

    private final Bank bank;
    private final Cashier cashier;

    public CashierWorker(Bank bank, Cashier cashier) {
        this.bank = bank;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        while (bank.bankIsOpen()) {
            Client client = bank.getClientDeque().extract();
            if (client != null) {
                synchronized (client.getMonitor()) {
                    System.out.println(cashier.getName() + " start to service " + client.getClientName());

                    for (Enum clientAction : client.getClientActions()) {
                        performClientOperation(client, clientAction);
                    }
                    client.setWaitingInQueue(false);
                    client.getMonitor().notify();
                    System.out.println(cashier.getName() + " finished to service " + client.getClientName());
                }
            }
        }
    }

    private void performClientOperation(Client client, Enum clientAction) {
        if (clientAction.equals(ClientActionsEnums.Exchange)) {
            exchange();
        } else if (clientAction.equals(ClientActionsEnums.Pay)) {
            pay();
        } else if (clientAction.equals(ClientActionsEnums.TopUp)) {
            topUp(client);
        } else if (clientAction.equals(ClientActionsEnums.Transfer)) {
            transfer();
        } else if (clientAction.equals(ClientActionsEnums.Withdraw)) {
            withdraw(client);
        }
        System.out.println(cashier.getName() + ": banking operation with " + client.getClientName() + " has been completed.");
    }

    private void withdraw(Client client) {
        ClientsBankAccount clientsBankAccount = client.getClientsBankAccount();
        Timeout.oversleep(1000, 15000);
        int withdrawSum = RandomGenerator.get(1, 300);
        cashier.getFromCash(clientsBankAccount.withdrawFromAmount(withdrawSum));
    }

    private void topUp(Client client) {
        ClientsBankAccount clientsBankAccount = client.getClientsBankAccount();
        Timeout.oversleep(1000, 15000);
        int topUpSum = RandomGenerator.get(1, 5000);
        clientsBankAccount.addToAmount(topUpSum);
        cashier.addToCash(topUpSum);
    }

    private void transfer() {
        Timeout.oversleep(1000, 15000);
        int transferSum = RandomGenerator.get(1, 3000);
        cashier.addToCash(transferSum);
    }

    private void pay() {
        Timeout.oversleep(1000, 15000);
        int paySum = RandomGenerator.get(1, 5000);
        cashier.addToCash(paySum);
    }

    private void exchange() {
        int exchangeSum = RandomGenerator.get(1, 1000);
        Timeout.oversleep(1000, 15000);
        cashier.addToCash(exchangeSum);
        cashier.getFromCash(exchangeSum * 2);
    }
}

package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Cashier;
import by.it.chumak.bank.helper.Timeout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankWorker extends Thread {
    private final Bank bank;

    public BankWorker(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.printf("Bank opened");
        createCashiers();
        Timeout.sleep(1000);
        createManager();
        Timeout.sleep(1000);
        createClients();
    }

    private void createClients() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < bank.getCountClientsPlan(); i++) {
            executorService.execute(new ClientWorker(i+1, bank));
        }
        executorService.shutdown();
    }

    private void createManager() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new ManagerWorker(bank));
        executorService.shutdown();
    }

    private void createCashiers() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < bank.getCountClientsPlan() / 50; i++) {
            Cashier cashier = new Cashier(bank, i + 1);
            bank.addCashierToList(cashier);
            executorService.execute(new CashierWorker(bank, cashier));
        }
        executorService.shutdown();
    }
}

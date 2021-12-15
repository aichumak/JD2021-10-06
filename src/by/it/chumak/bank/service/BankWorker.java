package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Cashier;
import by.it.chumak.bank.helper.Timeout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankWorker extends Thread {
    private final Bank bank;

    public BankWorker(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(103);
        System.out.println("Bank opened");
        createCashiers(executorService);
        Timeout.sleep(1000);
        createManager(executorService);
        Timeout.sleep(1000);
        createClients(executorService);
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bank closed");
    }

    private void createClients(ExecutorService executorService) {
        for (int i = 0; i < bank.getCountClientsPlan(); i++) {
            executorService.execute(new ClientWorker(i + 1, bank));
        }
    }

    private void createManager(ExecutorService executorService) {
        executorService.execute(new ManagerWorker(bank));
    }

    private void createCashiers(ExecutorService executorService) {
        for (int i = 0; i < bank.getCountClientsPlan() / 50; i++) {
            Cashier cashier = new Cashier(bank, i + 1);
            bank.addCashierToList(cashier);
            executorService.execute(new CashierWorker(bank, cashier));
        }
    }
}

package by.it.chumak.bank;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Queue;
import by.it.chumak.bank.service.BankWorker;

public class Runner {
    public static void main(String[] args) {
        Queue queue = new Queue(30);
        Bank bank = new Bank(queue, 100, 50000, 1000);
        BankWorker bankWorker = new BankWorker(bank);
        bankWorker.start();
    }
}

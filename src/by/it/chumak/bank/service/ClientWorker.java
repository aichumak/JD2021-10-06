package by.it.chumak.bank.service;

import by.it.chumak.bank.entity.Bank;
import by.it.chumak.bank.entity.Client;

public class ClientWorker implements Runnable {

    private final Client client;
    private final Bank bank;

    public ClientWorker(int clientNumber, Bank bank) {
        this.client = new Client(clientNumber);
        this.bank = bank;
    }

    @Override
    public void run() {
        enterBank();
        goToQueue();
        exitBank();
    }

    private void goToQueue() {
        System.out.println(client.getClientName() + " go to queue");

        synchronized (client.getMonitor()) {
            bank.getClientDeque().add(client);
            client.setWaitingInQueue(true);
            try {
                while (client.isWaitingInQueue()) {
                    client.getMonitor().wait();
                }
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }

    private void enterBank() {
        bank.addClientsIn();
        System.out.println(client.getClientName() + " enter to bank");
    }

    private void exitBank() {
        bank.addClientsOut();
        System.out.println(client.getClientName() + " exit bank");
    }
}

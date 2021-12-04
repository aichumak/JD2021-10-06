package by.it.chumak.bank.entity;

import by.it.chumak.bank.helper.RandomGenerator;

public class Client {

    private final String clientName;
    private final ClientsBankAccount clientsBankAccount;

    public Client(int clientNumber) {
        this.clientName = "Client #" + clientNumber;
        this.clientsBankAccount = new ClientsBankAccount(RandomGenerator.get(100,500));
    }

    public String getClientName() {
        return clientName;
    }

    public ClientsBankAccount getClientsBankAccount() {
        return clientsBankAccount;
    }
}

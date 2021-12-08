package by.it.chumak.bank.entity;

import by.it.chumak.bank.helper.RandomGenerator;

import java.util.List;

public class Client {

    private boolean waitingInQueue = false;
    private final String clientName;
    private final ClientsBankAccount clientsBankAccount = new ClientsBankAccount(RandomGenerator.get(100, 5000));
    private final List<Enum> clientActions = ClientActions.getActions();

    public Client(int clientNumber) {
        this.clientName = "Client #" + clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public ClientsBankAccount getClientsBankAccount() {
        return clientsBankAccount;
    }

    public List<Enum> getClientActions() {
        return clientActions;
    }

    public boolean isWaitingInQueue() {
        return waitingInQueue;
    }

    public void setWaitingInQueue(boolean waitingInQueue) {
        this.waitingInQueue = waitingInQueue;
    }

    public Object getMonitor() {
        return this;
    }

}

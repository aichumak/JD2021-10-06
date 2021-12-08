package by.it.chumak.bank.entity;

public class ClientsBankAccount {
    private int amount;

    public ClientsBankAccount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addToAmount(int amount) {
        this.amount = this.amount + amount;
    }

    public boolean withdrawFromAmount(int amount) {
        if(this.amount - amount >= 0) {
            this.amount = this.amount - amount;
            return true;
        } else {
            return false;
        }
    }

}

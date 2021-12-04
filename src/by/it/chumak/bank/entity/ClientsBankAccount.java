package by.it.chumak.bank.entity;

public class ClientsBankAccount {
    private double amount;

    public ClientsBankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void addToAmount(double amount) {
        this.amount = this.amount + amount;
    }

    public boolean withdrawFromAmount(double amount) {
        if(this.amount - amount >= 0) {
            this.amount = this.amount - amount;
            return true;
        } else {
            return false;
        }
    }

}

package by.it.chumak.bank.entity;

public class Cashier {
    private final String name;
    private final Bank bank;
    private double cash;

    public Cashier(Bank bank, int cashierNumber) {
        this.name = "Cashier #" + cashierNumber;
        this.bank = bank;
        cash = 0;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public double getCash() {
        return cash;
    }

    public void addToCash(double amount){
        cash = cash + amount;
    }

    public double getFromCash(double amount){
        if (cash - amount >= 0) {
            cash = cash - amount;
            return amount;
        } else {
            double buffer = cash;
            cash = 0;
            return buffer;
        }
    }

}

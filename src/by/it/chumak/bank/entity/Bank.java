package by.it.chumak.bank.entity;

public class Bank {
    private double moneyStorageValue = 0;
    private double cashierMaxLimit = 0;

    public Bank(double moneyStorageValue, double cashierMaxLimit) {
        this.moneyStorageValue = moneyStorageValue;
        this.cashierMaxLimit = cashierMaxLimit;
    }

    public double getMoneyStorageValue() {
        return moneyStorageValue;
    }

    public double getMoney(double amount) {
        if (moneyStorageValue - amount >= 0) {
            moneyStorageValue = moneyStorageValue - amount;
            return amount;
        } else {
            double buffer = moneyStorageValue;
            moneyStorageValue = 0;
            return buffer;
        }
    }

    public void addMoney(double amount) {
        moneyStorageValue = moneyStorageValue + amount;
    }

    public double getCashierMaxLimit() {
        return cashierMaxLimit;
    }
}

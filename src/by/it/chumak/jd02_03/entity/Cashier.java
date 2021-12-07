package by.it.chumak.jd02_03.entity;

public class Cashier {

    private final String NAME;
    private final int NUMBER;
    private long total;
    private boolean cashierOpen;

    public Cashier(int number) {
        this.NAME = "Cashier № " + number;
        this.NUMBER = number;
        this.cashierOpen = false;
        this.total = 0;
    }

    public String getName() {
        return this.NAME;
    }

    public void setTotal(long total) {
        this.total = this.total + total;
    }

    public int getNumber() {
        return this.NUMBER;
    }

    public void openCashier() {
        this.cashierOpen = true;
    }

    public void closeCashier() {
        this.cashierOpen = false;
    }

    public boolean isClosed() {
        return !this.cashierOpen;
    }

    @Override
    public String toString() {
        return "\t" + this.NAME + " TOTAL=" + this.total + " ";
    }


}

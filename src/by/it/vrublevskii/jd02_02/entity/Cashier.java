package by.it.vrublevskii.jd02_02.entity;

public class Cashier {

    private String name;

    private double total;

    public Cashier(int number) {
        this.name = "cashier №" + number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "\t" + name + ", total=" + total + " ";
    }
}

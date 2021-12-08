package by.it.vrublevskii.jd02_01.old.entity;

public class Customer {

    private final String name;
    private double total;
    private final String type;

    public Customer() {
        this.name = "unknown";
        this.type = "average";
    }

    public Customer(int number) {
        name = "Customer # " + number;
        this.type = "average";
    }

    public Customer(String type, int number) {
        this.type = type;
        name = "Customer (" + type + ") # " + number;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public String getType() {
        return type;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return name;
    }
}

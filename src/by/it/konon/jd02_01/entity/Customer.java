package by.it.konon.jd02_01.entity;

public class Customer {
    private final String name;
    public double total;

    public Customer() {
        name = "unknown";
    }


    public Customer(int number) {

        name = "Customer # " + number;

    }

    public String getName() {
        return name;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return name;
    }
}

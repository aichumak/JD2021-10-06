package by.it.ithoitan.jd02_01.entity;

public class Customer  {
    private final String name;
    private double total;
    public Customer(int number){
        name = "Customer № " + number;
    }

    public Customer() {
        name = "unknown";
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

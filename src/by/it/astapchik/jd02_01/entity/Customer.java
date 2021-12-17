package by.it.astapchik.jd02_01.entity;

public class Customer {

    private final String name;
    private double total;

    public Customer() {
        name = "Unknown customer.";
    }

    public Customer(int number){
        name = "Customer: " + number;
    }

    public String getName(){
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

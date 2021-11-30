package by.it.chumak.jd02_01.entity;

public class Customer {

    private final String name;
    private double total;
    private final CustomerType customerType;

    public Customer(int number, CustomerType currentCustomerType) {
        name = currentCustomerType + " № " + number;
        customerType = currentCustomerType;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return name;
    }
}

package by.it.konon.jd02_01.entity;

public class Customer {

    private final String name;
    private double total;
    private final CustomerKind customerType;

    public Customer(int number, CustomerKind currentCustomerKind) {
        name = currentCustomerKind + " № " + number;
        customerType = currentCustomerKind;
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

    public CustomerKind getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return name;
    }
}

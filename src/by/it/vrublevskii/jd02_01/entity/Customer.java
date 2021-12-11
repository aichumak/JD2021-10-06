package by.it.vrublevskii.jd02_01.entity;

public class Customer {
    private final String name;
    private final int customerNumber;
    private final String customerType;

    public Customer(int customerNumber) {
        this.name = "anonim";
        this.customerNumber = customerNumber;
        this.customerType = "average";
    }

    public Customer(String name, int customerNumber) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.customerType = "average";
    }

    public Customer(int customerNumber, String customerType) {
        this.name = "anonim";
        this.customerNumber = customerNumber;
        this.customerType = customerType;
    }

    public Customer(String name, int customerNumber, String customerType) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return customerType;
    }

    @Override
    public String toString() {
        if (this.customerType.equals("average")) {
            return String.format("Customer %-11s №%- 4d: %-6s", " ", customerNumber, name);
        } else {
            return String.format("Customer (%-9s) №%- 4d: %-6s", customerType, customerNumber, name);
        }
    }
}

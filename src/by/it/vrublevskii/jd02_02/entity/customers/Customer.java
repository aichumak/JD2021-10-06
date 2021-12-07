package by.it.vrublevskii.jd02_02.entity.customers;

public abstract class Customer {
    private final String name;
    private final int customerNumber;
    private final String customerType;

    public Customer(int customerNumber) {
        this.name = "anonim";
        this.customerNumber = customerNumber;
        this.customerType = "average";
    }


    public String getName() {
        return name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerType() {
        return customerType;
    }
}

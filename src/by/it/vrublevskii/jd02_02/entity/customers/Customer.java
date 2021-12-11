package by.it.vrublevskii.jd02_02.entity.customers;

public abstract class Customer {
    private final String name;
    private final int customerNumber;

    public Customer(String name, int customerNumber) {
        this.name = name;
        this.customerNumber = customerNumber;
    }


    public String getName() {
        return name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

}

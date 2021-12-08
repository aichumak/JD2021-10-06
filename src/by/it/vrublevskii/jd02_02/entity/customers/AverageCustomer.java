package by.it.vrublevskii.jd02_02.entity.customers;

public class AverageCustomer extends Customer {

    public AverageCustomer(int customerNumber) {
        super("anonim", customerNumber);
    }

    public AverageCustomer(String name, int customerNumber) {
        super(name, customerNumber);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getCustomerNumber() {
        return super.getCustomerNumber();
    }
}

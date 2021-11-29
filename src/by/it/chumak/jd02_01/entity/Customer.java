package by.it.chumak.jd02_01.entity;

public class Customer {

    private final String name;
    //private double total; //BigDecimal
    private Enum customerType;

    public Customer(CustomerType customerType) {
        name = "unknown";
        this.customerType = CustomerType.Customer;
    }

    public Customer(int number, CustomerType currentCustomerType) {
        name = "Customer № " + number;
        customerType = currentCustomerType;
    }

    public String getName() {
        return name;
    }

    //public double getTotal() {
    //    return total;
    //}

    public Enum getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Enum customerType) {
        this.customerType = customerType;
    }

    //public void setTotal(double total) {
    //    this.total = total;
    //}

    @Override
    public String toString() {
        return name;
    }
}

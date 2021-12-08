package by.it.vrublevskii.jd02_01.helper;


import by.it.vrublevskii.jd02_01.entity.Customer;

public class CustomerGenerator {

    private CustomerGenerator() {
    }

    public static Customer get(int customerCounter) {
        int customerType = RandomGenerator.get(3);
        Customer customer;
        if (customerType == 0) {
            customer = new Customer(customerCounter, "Pensioner");
        } else if (customerType == 1) {
            customer = new Customer(customerCounter);
        } else {
            customer = new Customer(customerCounter, "Student");
        }
        return customer;
    }

}

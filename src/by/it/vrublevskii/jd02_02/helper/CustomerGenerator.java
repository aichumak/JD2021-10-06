package by.it.vrublevskii.jd02_02.helper;


import by.it.vrublevskii.jd02_02.entity.Customer;
import by.it.vrublevskii.jd02_02.entity.ShoppingCart;

public class CustomerGenerator {

    private CustomerGenerator() {
    }

    public static Customer get(int customerCounter) {
        int customerType = RandomGenerator.get(3);
        Customer customer;
        ShoppingCart shoppingCart = new ShoppingCart();
        if (customerType == 0) {
            customer = new Customer(customerCounter, "Pensioner", shoppingCart);
        } else if (customerType == 1) {
            customer = new Customer(customerCounter, shoppingCart);
        } else {
            customer = new Customer(customerCounter, "Student", shoppingCart);
        }
        return customer;
    }

//    public static Customer get(int customerCounter) {
//        int customerType = RandomGenerator.get(3);
//        Customer customer;
//        if (customerType == 0) {
//            customer = new Pensioner(customerCounter);
//        } else if (customerType == 1) {
//            customer = new AverageCustomer(customerCounter);
//        } else {
//            customer = new Student(customerCounter);
//        }
//        return customer;
//    }
}

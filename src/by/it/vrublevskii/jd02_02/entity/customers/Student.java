package by.it.vrublevskii.jd02_02.entity.customers;

public class Student extends Customer {

    public Student(int customerNumber) {
        super("anonim", customerNumber);
    }

    public Student(String name, int customerNumber) {
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

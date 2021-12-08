package by.it.vrublevskii.jd02_02.entity.customers;

public class Pensioner extends Customer{

    public Pensioner(int customerNumber) {
        super("anonim", customerNumber);
    }

    public Pensioner(String name, int customerNumber) {
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

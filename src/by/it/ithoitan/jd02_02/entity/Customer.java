package by.it.ithoitan.jd02_02.entity;

public class Customer {
    private final String name;
    public Customer(int number){
        name = "Customer #" + number;
    }

    public Customer() {
        name = "unknown";
    }

    @Override
    public String toString() {
        return name;
    }
}

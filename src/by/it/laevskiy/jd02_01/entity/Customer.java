package by.it.laevskiy.jd02_01.entity;

public class Customer {
    private final String name;
    private double total; //BigDecimal

    public Customer() {
        name = "unknown";
    }

    public Customer(int number) {
        name="Customer №"+number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package by.it.drankevich.jd02_01.entity;

public class Customer {

    private final String name;

    private double total;

    public Customer(){
        name="unknown";
    }

    public Customer(int number) {
        name="Customer №"+number;

    }

    public Customer(int number, String buyerName) {
        name="Customer №"+number+" "+buyerName;

    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return name;
    }
}

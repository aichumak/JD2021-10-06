package by.it.brutski.jd02_01.entity;

public class Customer {
    private final String name;
    private double total; //BigDecimal

    public Customer(){
        name = "unknown";
    }

    public Customer(int number) {
        name = "Customer № " + number;
    }

    public String getName(){
        return name;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String toString(){
        return name;
    }
}

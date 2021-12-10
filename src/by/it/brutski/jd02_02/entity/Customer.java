package by.it.brutski.jd02_02.entity;

public class Customer {
    private final String name;
    private double total; //BigDecimal
    private boolean flag;


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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getMonitor(){
        return this;
    }

    public String toString(){
        return name;
    }
}

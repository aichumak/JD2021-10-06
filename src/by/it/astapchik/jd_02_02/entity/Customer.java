package by.it.astapchik.jd_02_02.entity;

public class Customer {

    private final String name;
    private double total;

    public boolean isFlagWait() {
        return flagWait;
    }

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    private boolean flagWait;

    public Customer() {
        name = "Unknown customer.";
    }

    public Customer(int number){
        name = "Customer: " + number;
    }

    public String getName(){
        return name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}

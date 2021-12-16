package by.it.serkutsyev.jd02_03.entity;

public class Customer {
    private final String name;
    private double total;
    private boolean flagWaiting;


    public Customer() {
        name="unknown";
    }

    public Customer(int number) {
        name="Customer № "+number;
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


    public boolean isFlagWaiting() {
        return flagWaiting;
    }

    public void setFlagWaiting(boolean flagWaiting) {
        this.flagWaiting = flagWaiting;
    }

    public Object getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}

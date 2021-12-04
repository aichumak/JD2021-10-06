package by.it.drankevich.jd02_03.entity;

public class Customer {

    private final String name;

    private double total;
    boolean flagWaiting;


    public Customer() {
        name = "unknown";
    }

    public Customer(int number) {
        name = "Customer №" + number;

    }

    public Customer(int number, String buyerName) {
        name = "Customer №" + number + " " + buyerName;

    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = this.total+total;
    }

    public Object getMonitor() {
        return this;
    }

    public boolean isFlagWaiting() {
        return flagWaiting;
    }

    public void setFlagWaiting(boolean flagWaiting) {
        this.flagWaiting = flagWaiting;
    }

    @Override
    public String toString() {
        return name;
    }
}

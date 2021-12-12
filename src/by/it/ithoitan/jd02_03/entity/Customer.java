package by.it.ithoitan.jd02_03.entity;

public class Customer  {
    private final String name;
    private double total;
    private boolean flagWaining;
    public Customer(int number){
        name = "Customer № " + number;
    }

    public Customer() {
        name = "unknown";
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public boolean isFlagWaining() {
        return flagWaining;
    }

    public void setFlagWaining(boolean flagWaining) {
        this.flagWaining = flagWaining;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}

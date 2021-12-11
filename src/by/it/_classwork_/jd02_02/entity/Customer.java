package by.it._classwork_.jd02_02.entity;

public class Customer {

    private final String name;
    private double total; //BigDecimal
    private boolean flagWaining;

    public Customer() {
        name = "unknown";
    }

    public Customer(int number) {
        name = "Customer № " + number;
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

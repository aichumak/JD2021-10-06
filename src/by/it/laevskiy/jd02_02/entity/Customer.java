package by.it.laevskiy.jd02_02.entity;

public class Customer {
    private final String name;
    private double total; //BigDecimal
    private boolean flagWaiting;

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

    public Object getMonitor(){
        return this;
    }

    public double getTotal() {return total;}

    public void setTotal(double total) {this.total = total;}

    public boolean isFlagWaiting() {return flagWaiting;}

    public void setFlagWaiting(boolean flagWaiting) {this.flagWaiting = flagWaiting;}
}

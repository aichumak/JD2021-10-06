package by.it.chumak.jd02_02.entity;

public class Customer {

    private final String name;
    private double total;
    private final CustomerType customerType;
    private boolean flagWaiting;
    private ShoppingCard shoppingCard;


    public Customer(int number, CustomerType currentCustomerType) {
        name = currentCustomerType + " № " + number;
        customerType = currentCustomerType;
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public boolean isFlagWaiting() {
        return flagWaiting;
    }

    public void setFlagWaiting(boolean flagWaiting) {
        this.flagWaiting = flagWaiting;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

}

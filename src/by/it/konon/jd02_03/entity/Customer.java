package by.it.konon.jd02_03.entity;

public class Customer {

    private final String name;
    private final CustomerKind customerKind;
    private double total;
    private boolean flagWaiting;
    private ShoppingCard shoppingCard;


    public Customer(int number, CustomerKind currentCustomerKind) {
        this.name = currentCustomerKind + " № " + number;
        this.customerKind = currentCustomerKind;
    }

    public ShoppingCard getShoppingCard() {
        return this.shoppingCard;
    }

    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public String getName() {
        return this.name;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CustomerKind getCustomerKind() {
        return this.customerKind;
    }

    public void setFlagWaiting(boolean flagWaiting) {
        this.flagWaiting = flagWaiting;
    }

    public Object getMonitor() {
        return this;
    }

    public boolean isFlagWaiting() {
        return this.flagWaiting;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

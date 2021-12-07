package by.it.chumak.jd02_03.entity;

public class Customer {

    private final String NAME;
    private final CustomerType CUSTOMER_TYPE;
    private long total;
    private boolean flagWaiting;
    private ShoppingCard shoppingCard;


    public Customer(int number, CustomerType currentCustomerType) {
        this.NAME = currentCustomerType + " № " + number;
        this.CUSTOMER_TYPE = currentCustomerType;
    }

    public ShoppingCard getShoppingCard() {
        return this.shoppingCard;
    }

    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public String getName() {
        return this.NAME;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public CustomerType getCustomerType() {
        return this.CUSTOMER_TYPE;
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
        return this.NAME;
    }

}

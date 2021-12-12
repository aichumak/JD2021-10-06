package by.it.vrublevskii.jd02_03.entity;


public class Customer {
    private final String name;
    private final int customerNumber;
    private final String customerType;
    boolean flagWait;
    private final ShoppingCart shoppingCart;

    public Customer(int customerNumber, ShoppingCart shoppingCart) {
        this.name = "anonim";
        this.customerNumber = customerNumber;
        this.customerType = "average";
        this.shoppingCart = shoppingCart;
    }

    public Customer(int customerNumber, String customerType, ShoppingCart shoppingCart) {
        this.name = "anonim";
        this.customerNumber = customerNumber;
        this.customerType = customerType;
        this.shoppingCart = shoppingCart;
    }

    public Customer(String name, int customerNumber, String customerType, ShoppingCart shoppingCart) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.customerType = customerType;
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return customerType;
    }

    public boolean isFlagWait() {
        return flagWait;
    }

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Object getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        if (this.customerType.equals("average")) {
            return String.format("Customer %-11s №%- 4d: %-6s", " ", customerNumber, name);
        } else {
            return String.format("Customer (%-9s) №%- 4d: %-6s", customerType, customerNumber, name);
        }
    }
}

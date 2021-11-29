package by.it.chumak.jd02_01.entity;

public class CustomersCountRepo {

    private int customersCount;

    public CustomersCountRepo(int customersCount) {
        this.customersCount = customersCount;
    }

    public int getCustomersCount() {
        return customersCount;
    }

    public void setCustomersCount(int customersCount) {
        this.customersCount = customersCount;
    }

    public void addCustomer() {
        this.customersCount = this.customersCount + 1;
    }

    public void removeCustomer() {
        this.customersCount = this.customersCount - 1;
    }
}

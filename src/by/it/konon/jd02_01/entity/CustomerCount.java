package by.it.konon.jd02_01.entity;

public class CustomerCount {

    private int customersCount;

    public CustomerCount(int customersCount) {
        this.customersCount = customersCount;
    }

    public int getCustomersCount() {
        return customersCount;
    }

    public void addCustomer() {
        this.customersCount = this.customersCount + 1;
    }

    public void removeCustomer() {
        this.customersCount = this.customersCount - 1;
    }
}

package by.it.astapchik.jd_02_02.entity;

public class Manager {
    private final int Plan;
    private volatile int counterEnteredCustomer = 0;
    private volatile int counterLeftCustomer = 0;

    public Manager(int plan) {
        this.Plan = plan;
    }

    public synchronized void addCustomer() {
        counterEnteredCustomer++;
    }

    public synchronized void removeCustomer() {
        counterLeftCustomer++;
    }

    public boolean isOpenedStore() {
        return counterEnteredCustomer != Plan;
    }

    public boolean isClosedStore() {
        return counterLeftCustomer == Plan;
    }

}

package by.it.kanaplianik.jd02_02;

public class NumberOfCustomers {
    private int value;

    public int getValue() {
        return value;
    }

    public void increment() {
        synchronized (this) {
            this.value++;
        }

        System.out.printf(String.format("%s customers inside the shop \n", value));
    }

    public void decrement() {
        synchronized (this) {
            this.value--;
        }
    }
}

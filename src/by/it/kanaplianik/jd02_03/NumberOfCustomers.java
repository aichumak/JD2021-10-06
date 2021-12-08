package by.it.kanaplianik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfCustomers {
    private final AtomicInteger value = new AtomicInteger();

    public AtomicInteger getValue() {
        return value;
    }

    public void increment() {
    this.value.getAndIncrement();
        System.out.printf(String.format("%s customers inside the shop \n", value));
    }

    public void decrement() {
            this.value.getAndDecrement();
    }
}

package by.it.drankevich.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier {
    private final String name;

    private double total;
    private static double totalStoreCash=0;

    public Cashier(int number) {
        this.name = "Cashier №"+number;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public synchronized void setTotal(double total) {
        this.total = this.total+total;
        totalStoreCash=totalStoreCash+total;
    }

    public static double getTotalStoreCash() {
        return totalStoreCash;
    }

    @Override
    public String toString() {
        return "\t"+ name+" TOTAL "+total+" ";

    }
}

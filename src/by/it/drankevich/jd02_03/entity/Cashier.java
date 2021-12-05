package by.it.drankevich.jd02_03.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Cashier {
    private final String name;

    private double total;
    private static double totalStoreCash=0;
    private static final Semaphore semaphore=new Semaphore(1);

    public Cashier(int number) {
        this.name = "Cashier №"+number;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public  void setTotal(double total) {
        this.total = this.total+total;
        try {
            semaphore.acquire();
            totalStoreCash=totalStoreCash+total;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();

    }

    public static synchronized double getTotalStoreCash() {
        return totalStoreCash;
    }

    @Override
    public String toString() {
        return "\t"+ name+" TOTAL "+total+" ";

    }
}

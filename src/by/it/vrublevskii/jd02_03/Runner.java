package by.it.vrublevskii.jd02_03;


import by.it.vrublevskii.jd02_03.entity.Manager;
import by.it.vrublevskii.jd02_03.entity.Queue;
import by.it.vrublevskii.jd02_03.entity.Store;
import by.it.vrublevskii.jd02_03.servise.StoreThread;

public class Runner {
    public static void main(String[] args) {
        new StoreThread(
                new Store(
                        new Manager(100),
                        new Queue(30)
                )
        ).start();
    }
}

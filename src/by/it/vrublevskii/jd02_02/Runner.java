package by.it.vrublevskii.jd02_02;


import by.it.vrublevskii.jd02_02.entity.Manager;
import by.it.vrublevskii.jd02_02.entity.Queue;
import by.it.vrublevskii.jd02_02.entity.Store;
import by.it.vrublevskii.jd02_02.servise.StoreThread;

public class Runner {
    public static void main(String[] args) {
        new StoreThread(
                new Store(
                        new Manager(100),
                        new Queue()
                )
        ).start();
    }
}

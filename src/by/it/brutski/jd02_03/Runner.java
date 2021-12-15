package by.it.brutski.jd02_03;

import by.it.brutski.jd02_03.entity.Manager;
import by.it.brutski.jd02_03.entity.Queue;
import by.it.brutski.jd02_03.entity.Store;
import by.it.brutski.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue(30);
        //создаем магазин:
        Store store = new Store(manager, queue);
        //запускаем магазин:
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}

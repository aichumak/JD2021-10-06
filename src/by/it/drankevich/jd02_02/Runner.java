package by.it.drankevich.jd02_02;

import by.it.drankevich.jd02_02.entity.Manager;
import by.it.drankevich.jd02_02.entity.Queue;
import by.it.drankevich.jd02_02.entity.Store;
import by.it.drankevich.jd02_02.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {

        Manager manager = new Manager(100);
        Queue queue = new Queue();

        Store store = new Store(manager, queue);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();

    }
}

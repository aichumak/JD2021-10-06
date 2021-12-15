package by.it.serkutsyev.jd02_03;

import by.it.serkutsyev.jd02_03.entity.Manager;
import by.it.serkutsyev.jd02_03.entity.Queue;
import by.it.serkutsyev.jd02_03.entity.Store;
import by.it.serkutsyev.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue(30);
        Store store = new Store(manager, queue);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}

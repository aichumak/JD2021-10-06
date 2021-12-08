package by.it.vrublevskii.jd02_02.old;

import by.it.vrublevskii.jd02_02.old.entity.Customer;
import by.it.vrublevskii.jd02_02.old.entity.Manager;
import by.it.vrublevskii.jd02_02.old.entity.Queue;
import by.it.vrublevskii.jd02_02.old.entity.Store;
import by.it.vrublevskii.jd02_02.old.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store(manager, queue);
        Customer customer = new Customer();
        StoreWorker storeWorker = new StoreWorker(store, customer);
        storeWorker.start();
    }
}

package by.it.drankevich.finalTask;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.servise.PlayerGeneratorTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        Collection collection=new Collection();
        ExecutorService threadPool= Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 20; i++) {
            PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(collection);
            threadPool.execute(playerGeneratorTask);

        }
        threadPool.shutdown();

    }
}

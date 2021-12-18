package by.it.drankevich.finalTask;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.helper.Filenames;
import by.it.drankevich.finalTask.servise.PlayerGeneratorTask;
import by.it.drankevich.finalTask.servise.PlayerWorker;
import by.it.drankevich.finalTask.servise.PlayerReaderTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        String path = Filenames.getFullPath(PlayerWorker.class, "log.txt");
        Collection collection = new Collection();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 20; i++) {
            PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(collection);
            threadPool.execute(playerGeneratorTask);

        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1000, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PlayerReaderTask.readerTask(path);

    }
}

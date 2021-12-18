package by.it.chumak.jd02_07;

import by.it.chumak.jd02_07.model.GetPathMethod;
import by.it.chumak.jd02_07.service.PlayerGeneratorTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        GetPathMethod pathMethods = new GetPathMethod();
        String path = pathMethods.getFilePath(Runner.class, "");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask(path, "Players" + i + ".txt");
        //PlayerReaderTask playerReaderTask = new PlayerReaderTask(path, new ArrayList<>());

        for (int i = 0; i < 20; i++) {
            executorService.execute(new PlayerGeneratorTask(path, "Players" + i + ".txt"));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //playerGeneratorTask.start();
        //playerReaderTask.start();

    }
}

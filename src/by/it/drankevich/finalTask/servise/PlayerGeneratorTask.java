package by.it.drankevich.finalTask.servise;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.entity.Player;
import by.it.drankevich.finalTask.helper.Filenames;
import by.it.drankevich.finalTask.helper.RandomMaker;

import java.util.ArrayList;


public class PlayerGeneratorTask implements Runnable{
    private final Collection collection;
    ArrayList<PlayerWorker> playerWorkers = new ArrayList<>();
    String path = Filenames.getFullPath(PlayerWorker.class, "log.txt");


    public PlayerGeneratorTask(Collection collection) {
        this.collection=collection;
    }






    @Override
    public void run() {
        for (int i = 110; i <=120 ; i++) {
            Player player=new Player(i,(int)( Math.random() * 21) + 20, RandomMaker.random());

            PlayerWorker playerWorker=new PlayerWorker(collection,player);
            playerWorkers.add(playerWorker);
            playerWorker.start();

        }

        for (PlayerWorker playerWorker : playerWorkers) {
            try {
                playerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        PrintResult.print(path);




    }
}

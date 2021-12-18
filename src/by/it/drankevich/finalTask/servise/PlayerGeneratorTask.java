package by.it.drankevich.finalTask.servise;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.entity.Player;
import by.it.drankevich.finalTask.helper.Filenames;
import by.it.drankevich.finalTask.helper.RandomMaker;


public class PlayerGeneratorTask implements Runnable{
    private final Collection collection;


    public PlayerGeneratorTask(Collection collection) {
        this.collection=collection;
    }






    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++) {
            Player player=new Player(i,(int)( Math.random() * 21) + 20, RandomMaker.random());

            PlayerWorker playerWorker=new PlayerWorker(collection,player);
            playerWorker.start();

        }



    }
}

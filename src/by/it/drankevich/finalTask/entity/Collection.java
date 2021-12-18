package by.it.drankevich.finalTask.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Collection {
    private final BlockingDeque<Player> playerDeque;

    public Collection() {playerDeque=new LinkedBlockingDeque<>();
    }


    public void addPlayer(Player player) {

        try {
            playerDeque.putLast(player);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

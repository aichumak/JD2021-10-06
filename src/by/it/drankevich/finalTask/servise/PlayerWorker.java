package by.it.drankevich.finalTask.servise;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.entity.Player;
import by.it.drankevich.finalTask.helper.Filenames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerWorker extends Thread implements PlayAction{

    private final Collection collection;
    private final  Player player;

   String path = Filenames.getFullPath(PlayerWorker.class, "log.txt");
    public PlayerWorker(Collection collection, Player player) {
        this.collection=collection;
        this.player=player;
    }

    @Override
    public void run() {
        write();


    }

    @Override
    public String write() {
        collection.addPlayer(player);
            try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {


                writer.printf(player.toString()+"\n");
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        return path;
    }







}


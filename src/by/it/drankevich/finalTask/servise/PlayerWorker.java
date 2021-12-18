package by.it.drankevich.finalTask.servise;

import by.it.drankevich.finalTask.entity.Collection;
import by.it.drankevich.finalTask.entity.Player;
import by.it.drankevich.finalTask.helper.Filenames;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        getText(path);

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


    private static String getText(String filename) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            String s;
            while ((s = bufferedReader.readLine()) != null) {


                stringBuilder.append(s).append("\n");
                arrayList.add(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String s = arrayList.stream().limit(5).findFirst().get();
        System.out.println(s);
        return stringBuilder.toString();

    }
}

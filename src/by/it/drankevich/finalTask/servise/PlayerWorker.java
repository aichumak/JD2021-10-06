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


    private static void getText(String filename) {
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
        ArrayList<String> arrayList1 = new ArrayList<>();

        for (String s : arrayList) {
            if(s.contains("true")){
            if(s.contains("25")||s.contains("26")||s.contains("27")||s.contains("28")||s.contains("29")||s.contains("30")){

            arrayList1.add(s);
        }}}


            Object[] objects = arrayList1.stream().limit(5).map(String::toUpperCase).toArray();
            for (Object object : objects) {
                System.out.println(object.toString());


            }





}
}

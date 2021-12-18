package by.it.chumak.jd02_07.service;

import by.it.chumak.jd02_07.helpers.RandomGenerator;
import by.it.chumak.jd02_07.model.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlayerGeneratorTask implements Runnable {

    String path;

    public PlayerGeneratorTask(String path, String fileName) {
        this.path = path+fileName;
    }

    @Override
    public void run() {
        List<Player> playerList = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            Player player = new Player(i, RandomGenerator.get(20, 40), RandomGenerator.get(1, 2));
            playerList.add(player);
            writePlayerToFile(player, path);
        }
    }

    private void writePlayerToFile(Player player, String path) {
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(path, true))
        ) {
            writer.printf("%s, age: %d, active: %b%n", player.getName(), player.getAge(), player.isActive());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPath() {
        return path;
    }
}

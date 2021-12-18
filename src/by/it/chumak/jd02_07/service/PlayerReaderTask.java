package by.it.chumak.jd02_07.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerReaderTask implements Runnable {

    private final String path;
    private final List<String> linesList;

    public PlayerReaderTask(String path, List<String> linesList) {
        this.path = path;
        this.linesList = linesList;
    }


    @Override
    public void run() {
        List<String> bufferLinesList = new ArrayList<>();
        try {
            bufferLinesList = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : bufferLinesList) {
            if (checkTextLine(s)) {
                linesList.add(s);
            }
        }
    }

    private Boolean checkTextLine(String textLine) {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(textLine);

        while (matcher.find()) {
            int buffer = Integer.parseInt(matcher.group());
            if (buffer >= 25 && buffer <= 30) {
                return true;
            }
        }

        return false;

    }
}

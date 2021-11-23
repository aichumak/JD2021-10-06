package by.it.ithoitan.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TaskB {
    public static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try {
            BufferedReader innput = new BufferedReader(
                    new FileReader(dir(TaskB.class) + "Poem.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(dir(TaskB.class) + "resultTaskB.txt", true));
            String collect = innput.lines().collect(Collectors.joining("\n"));
            Pattern pattern = Pattern.compile("[\\p{Punct}]");
            Matcher matcher = pattern.matcher(collect);
            List<String> punct = new ArrayList<>();
            while (matcher.find()) {
                punct.add(matcher.group());
            }
            Pattern patternW = Pattern.compile("[а-яА-ЯЁё]+");
            Matcher matcherW = patternW.matcher(collect);
            List<String> words = new ArrayList<>();
            while (matcherW.find()) {
                words.add(matcherW.group());
            }

            System.out.print("words=" + words.size()
                    + ", punctuation marks=" + (punct.size() - 2));
            bufferedWriter.write("words=" + words.size()
                    + ", punctuation marks=" + punct.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

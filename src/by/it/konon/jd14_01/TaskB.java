package by.it.konon.jd14_01;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaskB {

    public static void main(String[] args) {
try {
    BufferedReader bufferedReader = new BufferedReader(
            new FileReader(direction(TaskB.class)+ "Poem.txt"));

    BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(direction(TaskB.class) + "resultTaskB.txt"));
    String join = bufferedReader.lines().collect(Collectors.joining("\n"));
    Pattern pattern = Pattern.compile("[...!,-?:;]+");
    Matcher matcher = pattern.matcher(join);
    ArrayList<String> delimiters = new ArrayList<>();
    while (matcher.find()) {
        delimiters.add(matcher.group());
    }
    Pattern pattern2 = Pattern.compile("[А-Яа-яЁё]+");
    Matcher matcher2 = pattern2.matcher(join);
    ArrayList<String> words = new ArrayList<>();
    while (matcher2.find()) {
        words.add(matcher2.group());
    }
         System.out.println("words=" + words.size() + " " + "punctuation marks="+ delimiters.size());
        bufferedWriter.write(words.size()+ delimiters.size());



} catch (FileNotFoundException e){
    throw new RuntimeException(e);
} catch (IOException e) {
    e.printStackTrace();
}

    }

    public static String direction(Class<TaskB> taskBClass) {
        String path = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String dir = name
                .replace(simpleName,"")
                .replace(".", File.separator);
        String direction = path + dir;
        return direction;
    }
}

package by.it.astapchik.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        String strings = poem.toString();
        String sentences = strings.replace("...", " ");
        Pattern pattern = Pattern.compile("([^.$|^!])+");
        Matcher matcher = pattern.matcher(sentences);
        String[] text = new String[0];
        int index = 0;

        while (matcher.find()){
            String rows = matcher.group().replaceAll
                    (
                    "[,-:.\\n]", " "
            )
                    .replaceAll("[\\s]{2,}", " "
            ).trim();
            text = Arrays.copyOf(text, text.length + 1);
            text[index] = rows;
            index++;
        }
        implementSorting(text);
        printResult(text);
    }

    static void implementSorting(String[] text) {
        Arrays.sort(text, Comparator.comparingInt(String::length));
    }

    static void printResult(String[] text) {
        for (String s : text) {
            System.out.println(s);
        }
    }
}
package by.it.brutski.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] strings = new String[0];
    private static int[] count = {};

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String string = matcher.group();
            process(string);
        }
        printResult();
    }

    private static void printResult() {
        for (int i = 0; i < strings.length; i++) {
            System.out.printf("%s=%d\n", strings[i], count[i]);
        }
    }

    private static void process(String word) {
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals(word)){
                count[i]++;
                return;
            }
        }
        strings = Arrays.copyOf(strings, strings.length + 1);
        count = Arrays.copyOf(count, count.length + 1);
        strings[strings.length - 1] = word;
        count[count.length - 1] = 1;
    }
}

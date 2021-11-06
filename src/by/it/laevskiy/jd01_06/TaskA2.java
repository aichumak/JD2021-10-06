package by.it.laevskiy.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words={};
    private static int[] counts={};

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        printResult();
    }

    private static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n",words[i],counts[i]);
        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)){
                counts[i] = counts[i] + 1;
                return;
            }
        }
        words=Arrays.copyOf(words,words.length+1);
        counts=Arrays.copyOf(counts,counts.length+1);
        words[words.length-1]=word;
        counts[counts.length-1]=1;
    }

}

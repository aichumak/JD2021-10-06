package by.it.chumak.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = {};
    private static int[] counts = {};

    public static void main(String[] args) {
        getTextA2();
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%s\n", words[i], counts[i]);
        }
    }

    private static void getTextA2() {
        String sbText = Poem.text;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sbText);

        while (matcher.find()) {
            String word = matcher.group();
            processWord(word);
        }
    }

    private static void processWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counts[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        counts = Arrays.copyOf(counts, counts.length + 1);
        words[words.length - 1] = word;
        counts[counts.length - 1] = 1;
    }
}

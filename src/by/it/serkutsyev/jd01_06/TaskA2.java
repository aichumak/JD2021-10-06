package by.it.serkutsyev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counter = new int[0];

    public static void main(String[] args) {
        StringBuilder poemText = new StringBuilder(Poem.text);
        Pattern patternForPoem = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcherForPoem = patternForPoem.matcher(poemText);
        while (matcherForPoem.find()) {
            int indexOfFirstElement = matcherForPoem.start();
            int indexOfLastElement = matcherForPoem.end();
            String word = poemText.substring(indexOfFirstElement, indexOfLastElement);
            wordUsageCounter(word);

        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counter[i]);

        }

    }

    private static void wordUsageCounter(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counter[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        counter = Arrays.copyOf(counter, counter.length + 1);
        words[words.length - 1] = word;
        counter[counter.length - 1] = 1;
    }
}

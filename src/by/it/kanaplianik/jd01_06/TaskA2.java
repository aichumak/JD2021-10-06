package by.it.kanaplianik.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] foundWords = {};
    private static int[] count = {};

    private static int position (String word) {
        for (int i = 0; i < foundWords.length; i++) {
            if (foundWords[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValid(int position) {
        return position >= 0;
    }



    public static void main (String [] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int pos = position(word);
            if (isValid(pos)) {
                count[pos]++;
            }
            else {
                int lastLength = foundWords.length;
                foundWords = Arrays.copyOf(foundWords,lastLength+1);
                foundWords[lastLength] = word;
                count = Arrays.copyOf(count,lastLength+1);
                count[lastLength] = 1;
            }
        }
        for (int i = 0; i < foundWords.length; i++) {
            System.out.println(foundWords[i] + "=" + count[i]);
        }
    }
}

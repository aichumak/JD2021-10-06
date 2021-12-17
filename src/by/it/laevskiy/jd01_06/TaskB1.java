package by.it.laevskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = compile.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (comparisonByPattern(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean comparisonByPattern(String word) {
        String consonant = "йцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ";
        String vowels = "уеыаоэяиюёУЕЫАОЭЯИЮЁ";
        for (int i = 0; i < consonant.length(); i++) {
            if (word.charAt(0) == consonant.charAt(i)) {
                for (int j = 0; j < vowels.length(); j++) {
                    if (word.charAt(word.length() - 1) == vowels.charAt(j)) {
                        return true;
                    } else if (j == vowels.length() - 1) return false;
                }
            }
        }
        return false;
    }
}
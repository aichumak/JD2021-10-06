package by.it.vrublevskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.toLowerCase;

public class TaskB1 {

    static char[] charArray = {'ё', 'у', 'е', 'ы', 'а', 'и', 'о', 'э', 'я', 'ю'};
    static int finder;
    static char a;

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            examination(word);
        }
    }

    private static void examination(String word) {
        a = word.charAt(0);
        a = toLowerCase(a);
        finder = 0;
        for (char comparableChar : charArray) {
            if (a != comparableChar) {
                finder++;
            }
        }
        if (finder == 10) {
            a = word.charAt(word.length() - 1);
            for (char comparableChar : charArray) {
                if (a == comparableChar) {
                    finder++;
                }
            }
        }
        if (finder == 11) {
            System.out.println(word);
        }
    }
}

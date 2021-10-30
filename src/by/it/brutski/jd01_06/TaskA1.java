package by.it.brutski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");

        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int startPosition = matcher.start();
            int endPosition = matcher.end();
            int length = endPosition - startPosition;

            sb.setCharAt(startPosition + 3, '#');

            if (length >= 7) {
                sb.setCharAt(startPosition + 6, '#');
            }
        }
        System.out.println(sb);
    }
}

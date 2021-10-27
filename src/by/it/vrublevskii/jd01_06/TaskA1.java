package by.it.vrublevskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynamicText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynamicText);
        while (matcher.find()) {
            int startWord = matcher.start();
            dynamicText.setCharAt(startWord + 3, '#');
            int finishWord = matcher.end();
            if (finishWord - startWord >= 7) {
                dynamicText.setCharAt(startWord + 6, '#');
            }
        }
        System.out.println(dynamicText);
    }
}

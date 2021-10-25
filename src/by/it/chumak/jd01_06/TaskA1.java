package by.it.chumak.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        String textTaskA1;

        textTaskA1 = getTextA1();
        System.out.print(textTaskA1);
        //System.out.println();
    }

    private static String getTextA1() {
        StringBuilder sbText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(sbText);
        while (matcher.find()) {
            int startWordPosition = matcher.start();
            int nextSymbolPosition = matcher.end();
            int lengthWord = nextSymbolPosition - startWordPosition;

            if (lengthWord >= 4) {
                sbText.setCharAt(startWordPosition + 3, '#');
                if (lengthWord >= 7) {
                    sbText.setCharAt(startWordPosition + 6, '#');
                }
            }
        }
        return sbText.toString();
    }
}

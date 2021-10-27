package by.it.kachanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA2 {
    static String[] arrayText;
    static int count;

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("\\s|,|\\.|\\.\\.\\.|:|-|!|\\\\n");
        arrayText = text.split(String.valueOf(pattern));
        String word;
        for (String s : arrayText) {
            if (s.equals("")) {
                continue;
            }
            word = s;
            count = 0;
            for (String value : arrayText) {
                if (value.equals(word)) {
                    count++;
                }
            }
            System.out.printf("%s=%d\n", word, count);
        }
    }
}



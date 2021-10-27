package by.it.drankevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();

            if (process(word) == true) {
                System.out.println(word);
            }

        }

    }

    private static boolean process(String word) {
        String a = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        String b = "аоэеёиыуюяАОЭЕЁИЫУЮЯ";
        for (int i = 0; i < a.length(); i++) {
            if (word.charAt(0) == a.charAt(i)) {
                for (int j = 0; j < b.length(); j++) {
                    if (word.charAt(word.length() - 1) == b.charAt(j)) {
                        return true;
                    } else if (j == b.length() - 1) return false;

                }
            }

        }
        return false;

    }
}



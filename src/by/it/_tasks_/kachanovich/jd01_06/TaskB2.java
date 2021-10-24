package by.it._tasks_.kachanovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    static String[] arrayText;

    //    Вывести через \n все предложения текста в порядке возрастания количества символов
//            (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
//    последовательности на один пробел и выполнить trim() для каждого предложения.
    public static void main(String[] args) {
        String text = Poem.text;
        arrayText = text.split("\\n|\\.$");
        Pattern pattern = Pattern.compile("[^а-яА-ЯЁё]{1,4}");
        for (int i = 0; i < arrayText.length; i++) {
            Matcher matcher = pattern.matcher(arrayText[i]);
            while (matcher.find()) {

            }
        }

    }
}

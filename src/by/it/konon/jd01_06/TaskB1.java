package by.it.konon.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();


            char[] arrayVowel = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};

            char[] arrayConsonant = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н',
                    'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

            for (int i = 0; i < arrayConsonant.length; i++) {
                if (arrayConsonant[i] == Character.toLowerCase(word.charAt(0))) {
                    for (int j = 0; j < arrayVowel.length; j++) {
                        if (arrayVowel[j] == word.charAt(word.length() - 1)) {
                            System.out.println(word);
                            break;
                        }
                    }
                }

            }
        }
    }
}





package by.it.kanaplianik.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main (String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (isWordStartsWithConsonantAndEndsWithVolwes(word)){
                System.out.println(word);
            }
        }
    }
    private static boolean isWordStartsWithConsonantAndEndsWithVolwes (String word){
        Character[] vowelsChar = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
        Character[] consonantsChar = {'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'ж', 'Ж', 'з', 'З', 'й', 'Й', 'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'п', 'П', 'р', 'Р', 'с', 'С', 'т', 'Т', 'ф', 'Ф', 'х', 'Х', 'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш', 'щ', 'Щ'};
        int firstCharIndex = 0;
        Character firstChar = word.charAt(firstCharIndex);
        int lastCharIndex = word.length() - 1;
        Character lastChar = word.charAt(lastCharIndex);
        return (Arrays.asList(consonantsChar).contains(firstChar)) && (Arrays.asList(vowelsChar).contains(lastChar));
    }
}

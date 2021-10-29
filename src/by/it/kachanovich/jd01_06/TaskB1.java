package by.it.kachanovich.jd01_06;

import java.util.regex.Pattern;

public class TaskB1 {
    static String[] arrayText;

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("\\s|,|\\.|\\.\\.\\.|:|-|!|\\\\n");
        arrayText = text.split(String.valueOf(pattern));
        wordStartConsonantEndVowel(arrayText);
    }

    private static void wordStartConsonantEndVowel(String[] array) {
        char[] word;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                continue;
            }
            word = array[i].toCharArray();
            if ((word[0] != 'а' &
                    word[0] != 'у' &
                    word[0] != 'о' &
                    word[0] != 'и' &
                    word[0] != 'э' &
                    word[0] != 'ы' &
                    word[0] != 'я' &
                    word[0] != 'ю' &
                    word[0] != 'ё' &
                    word[0] != 'е' &
                    word[0] != 'А' &
                    word[0] != 'У' &
                    word[0] != 'О' &
                    word[0] != 'И' &
                    word[0] != 'Э' &
                    word[0] != 'Я' &
                    word[0] != 'Ю' &
                    word[0] != 'Ё' &
                    word[0] != 'Е' &
                    word[0] != 'Ы') &
                    (word[word.length - 1] == 'а' |
                            word[word.length - 1] == 'у' |
                            word[word.length - 1] == 'о' |
                            word[word.length - 1] == 'и' |
                            word[word.length - 1] == 'э' |
                            word[word.length - 1] == 'я' |
                            word[word.length - 1] == 'ю' |
                            word[word.length - 1] == 'ё' |
                            word[word.length - 1] == 'е' |
                            word[word.length - 1] == 'ы' |
                            word[word.length - 1] == 'А' |
                            word[word.length - 1] == 'У' |
                            word[word.length - 1] == 'О' |
                            word[word.length - 1] == 'И' |
                            word[word.length - 1] == 'Э' |
                            word[word.length - 1] == 'Я' |
                            word[word.length - 1] == 'Ю' |
                            word[word.length - 1] == 'Ё' |
                            word[word.length - 1] == 'Е' |
                            word[word.length - 1] == 'Ы')) {
                System.out.printf("%s\n", array[i]);
            }
        }
    }
}

package by.it.astapchik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] vowels =  new char[] {
                                    'а', 'и', 'е', 'ё', 'о', 'у', 'ы', 'э', 'ю', 'я',
                                    'A', 'И', 'Е', 'Ё', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'
                                    };
    private static char[] consonants =  new char[] {
            'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ',
            'Б','В','Г','Д','Ж','З','Й','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ',
            };
    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[a-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(poem);
        while (matcher.find()){
            String word = matcher.group();
            int length = word.length();
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(length-1);

            for (int i = 0; i < consonants.length; i++) {
                for (int j = 0; j < vowels.length; j++) {
                    if(firstLetter == consonants[i] && lastLetter == vowels[j]) {
                        System.out.println(word);
                    }
                }
            }
        }
    }

}

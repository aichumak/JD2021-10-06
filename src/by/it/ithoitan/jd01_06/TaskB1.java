package by.it.ithoitan.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            int startWordPosition = matcher.start();
            int endtWordPosition = matcher.end() - 1;
            char first = text.charAt(startWordPosition);
            char last = text.charAt(endtWordPosition);
            String consonants = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
            String vowels = "аоэеёиыуюяАОЭЕЁИЫУЮЯ";
            for (int i = 0; i < consonants.length(); i++) {
                if (consonants.charAt(i) == first) {
                    for (int j = 0; j < vowels.length(); j++) {
                        if (vowels.charAt(j) == last) {
                            System.out.println(word);

                        }


                    }

                }

            }

        }
    }
}


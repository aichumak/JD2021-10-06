package by.it.serkutsyev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder poemText = new StringBuilder(Poem.text);
        Pattern patternForPoem = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcherForPoem = patternForPoem.matcher(poemText);
        while (matcherForPoem.find()) {
            int startElement = matcherForPoem.start();
            poemText.deleteCharAt(startElement+3);
            poemText.insert(startElement+3,'#');
            if (matcherForPoem.end() - matcherForPoem.start() >= 7) {
                poemText.setCharAt(matcherForPoem.start()+6, '#');
            }
        }
        System.out.printf("%s", poemText);

    }

}



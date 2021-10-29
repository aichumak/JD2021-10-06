package by.it.chumak.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sbText = new StringBuilder(Poem.text.replace("...", " "));
        Pattern pattern1 = Pattern.compile("([^.$|^!])+");
        Matcher matcher = pattern1.matcher(sbText);
        String[] arrayTextSentences = new String[0];
        int arrayIndex = 0;

        while (matcher.find()) {
            String textLine = matcher.group().replaceAll("[-,:.\\n]", " ").replaceAll("[\\s]{2,}", " ").trim();
            arrayTextSentences = Arrays.copyOf(arrayTextSentences, arrayTextSentences.length + 1);
            arrayTextSentences[arrayIndex] = textLine;
            arrayIndex++;
        }

       Arrays.sort(arrayTextSentences, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return o1.length() - o2.length();
           }
       });

        for (String element : arrayTextSentences) {
            System.out.printf("%s\n", element);
        }
    }
}

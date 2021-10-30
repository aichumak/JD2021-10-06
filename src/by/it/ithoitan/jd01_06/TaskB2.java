package by.it.ithoitan.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        //StringBuilder text = new StringBuilder(Poem.text);
        String text = Poem.text;
        String withoutSumbol = text.replaceAll("[\n]", "");
        String nextText = withoutSumbol.replaceAll("[!.?]", "\n");
        System.out.println(nextText);
        String withoutSumbol2 = nextText.replaceAll("[!.,;:-]", "");
        System.out.println(withoutSumbol2);

        // withoutSumbol.trim();
        //withoutSumbol.split(" ");
        // System.out.println(withoutSumbol);

        /** Pattern pattern = Pattern.compile("[.]+");
         Matcher matcher = pattern.matcher(withoutSumbol2);
         //System.out.println(text);
         while (matcher.find()) {
         int startSentence = matcher.start();
         int endSentence = matcher.end();
         int lengthSentence = startSentence-endSentence; */
        String trim = withoutSumbol2.trim();
        String[] a = trim.split("\n");
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = j + 1; i < a.length; i++) {
                if (a[i].length()<a[j].length()) {
                    String temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }

            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }


        // String sentence = matcher.group();
        //int start = matcher.start();


        // System.out.println(sentence);
    }


}






package by.it.chumak.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        StringBuilder sbText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sbText);
        String text = "";
        long startTime, finishTime, elapsedTimeSlow, elapsedTimeFast;


        while (matcher.find()) {
            text = text.concat(matcher.group().trim());
            text = text.concat(" ");
        }

        startTime = System.nanoTime();
        String slowText = slow(text);
        finishTime = System.nanoTime();
        elapsedTimeSlow = (finishTime - startTime) / 1000;
        System.out.println(slowText);

        startTime = System.nanoTime();
        String fastText = fast(text);
        finishTime = System.nanoTime();
        elapsedTimeFast = (finishTime - startTime) / 1000;
        System.out.println(fastText);
        System.out.println("slow dt=" + elapsedTimeSlow);
        System.out.println("fast dt=" + elapsedTimeFast);
        System.out.println("Отличие в скорости dtSlow/dtFast=" + (elapsedTimeSlow / elapsedTimeFast));
    }

    private static String slow(String text) {
        String[] array = text.split(" ");
        String finalText = "";

        while (finalText.length() < 100000) {
            for (String element : array) {
                finalText = finalText.concat(element);
                finalText = finalText.concat(" ");
            }
        }
        return finalText;
    }

    private static String fast(String text) {
        String[] array = text.split(" ");
        StringBuilder finalText = new StringBuilder();

        while (finalText.length() < 100000) {
            for (String element : array) {
                finalText.append(element);
                finalText.append(" ");
            }
        }
        return finalText.toString();
    }
}

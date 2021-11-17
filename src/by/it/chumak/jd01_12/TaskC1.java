package by.it.chumak.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> arrayWords = scanTextToMap();
        Map<Integer, String> compressedArrayWords = compressMap(arrayWords);
        System.out.println(arrayWords);
        System.out.println(compressedArrayWords);
    }

    private static Map<Integer, String> compressMap(Map<Integer, String> arrayWords) {
        Map<Integer, String> compressedArrayWords = new HashMap<>();
        for (Map.Entry<Integer, String> entry : arrayWords.entrySet()) {
            if (!compressedArrayWords.containsValue(entry.getValue())) {
                compressedArrayWords.put(entry.getKey(), entry.getValue());
            }
        }

        return compressedArrayWords;
    }

    private static Map<Integer, String> scanTextToMap() {
        Map<Integer, String> arrayWordsOut = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");

        for (; ; ) {
            line = sc.next();
            if (line.equals("end")) {
                break;
            }
            stringBuilder.append(line);
            stringBuilder.append(" ");
        }

        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            arrayWordsOut.put(Math.abs(UUID.randomUUID().hashCode()), matcher.group());
        }

        return arrayWordsOut;
    }

}

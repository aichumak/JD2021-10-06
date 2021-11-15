package by.it.chumak.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        List<String> arrayWords = scanTextToList();
        HashSet<String> arrayUniqueWords = new HashSet<>(arrayWords);
        HashMap<String, Integer> resultingArray = getResultArray(arrayWords, arrayUniqueWords);

        printArray(resultingArray);
    }

    private static void printArray(HashMap<String, Integer> resultingArray) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : resultingArray.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue().toString());
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static HashMap<String, Integer> getResultArray(List<String> arrayWords, HashSet<String> arrayUniqueWords) {
        HashMap<String, Integer> resultingArray = new HashMap<>();

        for (String uniqueWord : arrayUniqueWords) {
            int count = 0;
            for (String word : arrayWords) {
                if (uniqueWord.equals(word)) {
                    count++;
                }
            }
            resultingArray.put(uniqueWord, count);
        }

        return resultingArray;
    }

    private static List<String> scanTextToList() {
        List<String> arrayWordsOut = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        StringBuilder text = new StringBuilder();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");

        for (; ; ) {
            line = sc.next();
            if (line.equals("end")) {
                break;
            }
            text.append(line);
            text.append(" ");
        }

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            arrayWordsOut.add(matcher.group());
        }

        return arrayWordsOut;
    }

}

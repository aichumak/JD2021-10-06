package by.it.kanaplianik.jd01_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {


    public static void main(String[] args) {
        String ourText = scanText();
        var splitted = Arrays.asList(ourText.split("[^a-zA-Z']"));
        System.out.println(splitted);

        HashMap<String, Integer> words = analyze(splitted);
        System.out.println(words);

    }

    private static String scanText() {
        Scanner scan = new Scanner(System.in);
        StringBuilder someText = new StringBuilder();
        while (true) {
            String line = scan.nextLine();
            if (line.equals("end")) {
                return someText.toString();
            } else {
                someText.append(line);

            }
        }
    }

    private static HashMap<String, Integer> analyze(List<String> words) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            else {
                if (result.containsKey(word)) {
                    Integer oldValue = result.get(word);
                    Integer newValue = oldValue+1;
                    result.put(word,newValue);
                }
                else {
                    result.put(word, 1);
                }
            }
        }
        return result;
    }

}

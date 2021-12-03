package by.it.vrublevskii.jd01_12;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> uniqueWordRegister = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder enteredWords = new StringBuilder();

        consoleInputToText(sc, enteredWords);
        System.out.println(countUniqueWords(uniqueWordRegister, enteredWords));
    }

    private static String countUniqueWords(HashMap<String, Integer> uniqueWordRegister, StringBuilder enteredWords) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+'*[a-zA-Z]*");
        Matcher matcher = pattern.matcher(enteredWords);
        while (matcher.find()) {
            String word = matcher.group();
            if (!uniqueWordRegister.containsKey(word)) {
                uniqueWordRegister.put(word, 1);
            } else {
                uniqueWordRegister.put(word, uniqueWordRegister.get(word) + 1);
            }
        }
        return String.valueOf(uniqueWordRegister);
    }

    private static void consoleInputToText(Scanner sc, StringBuilder enteredWords) {
        for (; ; ) {
            String inputWord = sc.nextLine();
            if (inputWord.equals("end")) {
                break;
            }
            enteredWords.append(inputWord).append(" ");
        }
    }
}

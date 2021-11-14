package by.it.ithoitan.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, String> hashmap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String wordEnglish = scanner.nextLine();
            hashmap.put(wordEnglish,wordEnglish);
            if (wordEnglish.equals("end")) {
                break;

            } else {
                for (Map.Entry<String, String> stringEntry : hashmap.entrySet()) {
                    stringEntry.setValue(stringEntry.getValue());
                    System.out.println(stringEntry);

                }
            }

        }
    }
}

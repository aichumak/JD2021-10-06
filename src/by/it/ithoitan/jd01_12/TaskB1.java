package by.it.ithoitan.jd01_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> hashmap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        for (; ; ) {
            String wordEnglish = scanner.nextLine();
            String trim = wordEnglish.trim();
            String s2 = trim.replaceAll("[\\n]","");
            builder.append(s2).append(" ");
            // System.out.println(builder);
            String[] s = builder.toString().split("[().,!?:;\\s]");
            //System.out.println(Arrays.toString(s));
            // String all = wordEnglish.trim().replaceAll("\\W", " ");
            // String[] s = all.split(" ");
            //  System.out.println(Arrays.toString(s));
            if (wordEnglish.equals("end")) {
                for (String s1 : s) {
                    Integer count = hashmap.get(s1);
                    if (count == null) {
                        count = 0;
                    }
                    hashmap.put(s1, count + 1);
                }
                System.out.println(hashmap);
                break;
            }
        }
    }
}









/**
        for (; ; ) {
            hashmap.put(wordEnglish,wordEnglish);
            if (wordEnglish.equals("end")) {
                break;

            } else {
                for (Map.Entry<String, String> stringEntry : hashmap.entrySet()) {
                    stringEntry.setValue(stringEntry.getValue());
                    System.out.println(stringEntry);

                }
            }

        } */



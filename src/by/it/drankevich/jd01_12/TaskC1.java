package by.it.drankevich.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TaskC1 {
    public static void main(String[] args) {
        TreeMap<String, String> treemap = new TreeMap<>();
        TreeMap<String, String> treemap1 = new TreeMap<>();


        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String word = sc.next();
            String key = Long.toString(System.nanoTime());
            if (word.equals("end")) break;
            else {
                treemap.put(key, word);
            }

        }
        System.out.println(treemap);


        Set<Map.Entry<String, String>> entries = treemap.entrySet();
        Set<Map.Entry<String, String>> entries1 = treemap1.entrySet();

        one:
        for (Map.Entry<String, String> entry : entries) {

            for (Map.Entry<String, String> entry1 : entries1) {
                if (entry.getValue().equals(entry1.getValue())) {
                    continue one;
                }
            }
            treemap1.put(entry.getKey(), entry.getValue());
        }
        treemap.clear();
        treemap.putAll(treemap1);
        System.out.println(treemap);
    }

}



package by.it.konon.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {


        ArrayList<String> text = new ArrayList<>();
        HashSet<String> strings = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String words = scanner.nextLine();
            if (words.equals("end")) break;
            else {
                String[] str = words.trim().split("[,;:!?\\s]+");
                for (String s : str) {
                    text.add(s);

                }
            }
        }
        Iterator<String> iterator = text.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();

            int wordCount = Collections.frequency(text, word);
            strings.add(word + ": " + wordCount);

        }


        System.out.println(strings);

    }
}



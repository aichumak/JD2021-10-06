package by.it.konon.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            } else {
                text.add(word);
            }
        }
        Object[] array = text.toArray();

        for (int i = 0; i < array.length; i++) {
            Object wordDepot;
            wordDepot = array[i];
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (wordDepot.equals(array[j])) {

                    count++;

                }
                System.out.println(array[j] + " " + count);
            }

        }


    }

}



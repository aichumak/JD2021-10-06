package by.it.laevskiy.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        int posZero = 0;

        Scanner scanner = new Scanner(System.in);


        for (; ; ) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            } else {
                Integer value = Integer.valueOf(word);
                if (value > 0) {
                    integers.add(posZero++, value);
                } else if (value == 0) {
                    integers.add(posZero, value);
                } else {
                    integers.add(value);
                }
            }
        }
        System.out.println(integers);
    }
}

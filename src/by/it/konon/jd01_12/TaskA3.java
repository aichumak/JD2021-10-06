package by.it.konon.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int position = 0;

        for (; ; ) {

            String word = scanner.next();
            if (word.equals("end")) {
                break;
            } else {
                Integer value = Integer.valueOf(word);
                if (value > 0) {
                    integers.add(position++, value);
                } else if (value == 0) {
                    integers.add(position, value);
                } else {
                    integers.add(value);
                }
            }
        }

        System.out.print(integers);
    }
}

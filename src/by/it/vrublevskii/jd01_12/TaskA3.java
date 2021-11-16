package by.it.vrublevskii.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        int positionZero = 0;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            } else {
                Integer value = Integer.valueOf(word);
                if (value > 0) {
                    integers.add(positionZero++, value);
                } else if (value == 0) {
                    integers.add(positionZero, value);
                } else {
                    integers.add(value);
                }
            }
        }
        System.out.println(integers);
    }
}

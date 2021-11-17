package by.it.drankevich.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        int pos = 0;
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String word = scanner.next();
            if (word.equals("end")) break;
            else {
                Integer value = Integer.valueOf(word);
                if (value > 0) {
                    array.add(pos++, value);
                }
                if (value == 0) {
                    array.add(pos, value);
                }
                if (value < 0) {
                    array.add(value);

                }


            }

        }
        System.out.println(array);
    }
}

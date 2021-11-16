package by.it.chumak.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        int posZero = 0;
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (; ; ) {
            String line = sc.next();
            if (line.equals("end")) {
                break;
            } else {
                int value = Integer.parseInt(line);
                if (value > 0) {
                    list.add(posZero++, value);
                } else if (value == 0) {
                    list.add(posZero, value);
                } else {
                    list.add(Integer.valueOf(line));
                }
            }
        }

        System.out.println(list);
    }
}

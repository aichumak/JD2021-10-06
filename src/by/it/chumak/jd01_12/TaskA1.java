package by.it.chumak.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        TaskA1 taskA1 = new TaskA1();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(1 + random.nextInt(10));
        }
        System.out.println(list);
        taskA1.clearBad(list);
        System.out.println(list);
    }

    void clearBad(List<Integer> grades) {
        grades.removeIf(grade -> grade < 4);
    }
}

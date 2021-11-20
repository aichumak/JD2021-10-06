package by.it.vrublevskii.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(40)+20;
        for (int i = 0; i < count; i++) {
            grades.add(random.nextInt(10)+1);
        }
        System.out.println(grades);
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(grades);


    }

    void clearBad(List<Integer> grades){
        grades.removeIf(grade -> grade < 4);
        System.out.println(grades);
    }
}

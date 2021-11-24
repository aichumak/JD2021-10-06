package by.it.serkutsyev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(20)+20;
        for (int i = 0; i < count; i++) {
            grades.add(random.nextInt(10)+1);
        }
        System.out.println("grades before cut-off:"+grades);
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(grades);
        System.out.println("grades after cut-off:"+grades);


    }
    void clearBad(List<Integer> grades){
        Iterator<Integer> iteratorForGrades = grades.iterator();
        while (iteratorForGrades.hasNext()){
            int grade = iteratorForGrades.next();
            if (grade<4){
                iteratorForGrades.remove();
            }

        }


    }
}

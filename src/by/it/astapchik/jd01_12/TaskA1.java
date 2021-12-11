package by.it.astapchik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {
    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(20) + 20;
        for (int i = 0; i < count; i++) {
            grades.add(1 + random.nextInt(10));
        }
        System.out.println("Grades: " + grades);
        TaskA1 task1 = new TaskA1();
        task1.clearBad(grades);
        System.out.println("Grades: " + grades);
    }

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if (grade < 4){
                iterator.remove();
            }
        }

    }

}

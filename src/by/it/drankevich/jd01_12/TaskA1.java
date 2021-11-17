package by.it.drankevich.jd01_12;

import java.util.*;

public class TaskA1 {
    public static void main(String[] args) {

        List<Integer> grades = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt((20) + 20);
        for (int i = 0; i < count; i++) {
            grades.add(random.nextInt(11));

        }
        System.out.println(grades);
        TaskA1 a = new TaskA1();
        a.clearBad(grades);
        System.out.println(grades);
    }

        void clearBad (List<Integer> grades ) {
            Iterator<Integer> iterator = grades.iterator();
            while (iterator.hasNext()){
              if( iterator.next()<4) {
                  iterator.remove();

              }

        }




    }
}

package by.it.ithoitan.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(20)+20;
        for (int i = 0; i < count; i++) {
            list.add(1+ random.nextInt(10));
        }
        System.out.println("list:" +list);
        TaskA1 task = new TaskA1();
        System.out.println("list:" +list);
    }
    void clearBad(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer lis = iterator.next();
        }
    }

}

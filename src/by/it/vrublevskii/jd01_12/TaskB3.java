package by.it.vrublevskii.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();
        peoplesArrayList.add("Егор");
        peoplesArrayList.add("Екатерина");
        peoplesArrayList.add("Владимир");
        peoplesArrayList.add("Виктор");
        peoplesArrayList.add("Анастасия");
        peoplesArrayList.add("Анастасия1");

        peoplesLinkedList.add("Егор");
        peoplesLinkedList.add("Екатерина");
        peoplesLinkedList.add("Владимир");
        peoplesLinkedList.add("Виктор");
        peoplesLinkedList.add("Анастасия");
        peoplesLinkedList.add("Анастасия1");
        System.out.println(process(peoplesArrayList));
        System.out.println(process(peoplesLinkedList));

    }

    static String process(ArrayList<?> peoples) {
        terminatePeople(peoples);
        return peoples.get(0).toString();
    }

    static String process(LinkedList<?> peoples) {
        terminatePeople(peoples);
        return peoples.get(0).toString();
    }

    private static void terminatePeople(List<?> peoples) {
        int numberPerson = 0;
        while (peoples.size() > 1) {
            Iterator<?> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                numberPerson++;
                iterator.next();
                if (numberPerson % 2 == 0) {
                    iterator.remove();
                }
            }
        }
    }
}

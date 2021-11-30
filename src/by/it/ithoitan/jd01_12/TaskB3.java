package by.it.ithoitan.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        while (peoples.size() > 1) {
            String first = peoples.remove(0);
            peoples.remove(0);
            peoples.add(first);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            String first = peoples.removeFirst();
            peoples.removeFirst();
            peoples.addLast(first);
        }
        return peoples.get(0);
    }
}


package by.it.kanaplianik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main (String[] args) {
        var p1 = new ArrayList<String>();
        for (int i = 0; i <= 4096; i++) {
            p1.add(Integer.toString(i));
        }

        var p2 = new LinkedList<String>();
        for (int i = 0; i <= 4096; i++) {
            p2.add(Integer.toString(i));
        }

        Long t = System.nanoTime();
        String rA = process(p1);
        Long tA = System.nanoTime() - t;

        t = System.nanoTime();
        String rB = process(p2);
        Long tB = System.nanoTime() - t;
    }

    static String process (ArrayList<String> peoples) {
        boolean needToDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                if (needToDelete) {
                    iter.remove();
                    needToDelete = false;
                } else {
                    needToDelete = true;
                }
            }
        }
        return peoples.get(0);
    }

    static String process (LinkedList<String> peoples) {
        boolean needToDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                if (needToDelete) {
                    iter.remove();
                    needToDelete = false;
                } else {
                    needToDelete = true;
                }
            }
        }
        return peoples.get(0);
    }
}
